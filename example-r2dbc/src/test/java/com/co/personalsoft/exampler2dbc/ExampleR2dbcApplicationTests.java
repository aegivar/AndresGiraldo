package com.co.personalsoft.exampler2dbc;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

import java.beans.BeanProperty;
import java.util.ArrayList;
import java.util.List;

@DataR2dbcTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ExampleR2dbcApplicationTests {
	ConnectionFactory connectionFactory = ConnectionFactories.get("r2dbc:h2:mem:///testdb");
	List<String> querys = new ArrayList<>();
	int cantidad = 10;
	@BeforeAll
	public void before(){
		querys.add("Drop table if exists products;");
		querys.add(" CREATE table PRODUCTS (" + " id INT AUTO_INCREMENT NOT NULL, " + " name VARCHAR2, "
				+ " price number); ");
		for (int i = 1; i < cantidad; i++) {
			querys.add("Insert into PRODUCTS(id,name,price) values("+i+", 'producto "+ i + "',"+(i*10)+");");
		}

	}


	public void insertarPrducto(){
		for (String query : querys){
			Mono.from(connectionFactory.create())
					.flatMapMany((connectionFactory)->connectionFactory.createStatement(query).execute()).subscribe(result -> {
						result.getRowsUpdated().subscribe(new Subscriber<Integer>() {
							@Override
							public void onSubscribe(Subscription s) {
								s.request(1);
							}

							@Override
							public void onNext(Integer integer) {
								System.out.println("Ejecuto sentencia" + integer);
							}

							@Override
							public void onError(Throwable t) {
								t.printStackTrace();
							}

							@Override
							public void onComplete() {
								System.out.println("Completed");
							}
						});
			});
		}
	}

	@Test
	public void consultsTest(){
		insertarPrducto();
		Mono.from(connectionFactory.create())
				.flatMapMany((connectionFactory)->connectionFactory
						.createStatement("select  name from PRODUCTS where id = $1").bind("$1",3)
						.execute())
				.flatMap(result->result.map((row,rowMetadata)->row.get("name")))
				.doOnNext(System.out::println)
				.subscribe();
	}

	@Test
	public void updateTest(){
		insertarPrducto();
		Mono.from(connectionFactory.create())
				.flatMapMany((connectionFactory)->connectionFactory
						.createStatement("update PRODUCTS set name = $2  where id = $1").bind("$1",3).bind("$2","hola mundo")
						.execute())
				.subscribe(result -> {
					result.getRowsUpdated().subscribe(new Subscriber<Integer>() {
						@Override
						public void onSubscribe(Subscription s) {
							s.request(1);
						}

						@Override
						public void onNext(Integer integer) {
							System.out.println("update sentencia" + integer);
						}

						@Override
						public void onError(Throwable t) {
							t.printStackTrace();
						}

						@Override
						public void onComplete() {
							System.out.println("Completed");
						}
					});
				});
	}

	@Test
	void contextLoads() {
	}

}
