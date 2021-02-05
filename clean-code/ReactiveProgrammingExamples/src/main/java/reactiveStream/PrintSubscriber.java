package reactiveStream;

import java.util.concurrent.Flow;

public class PrintSubscriber implements Flow.Subscriber<Integer>{

    private Flow.Subscription subscription;

    /**
     * conexion con el intermediario
     * **/
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(2);
    }

    /***
     * se recibe la data que retorna el intermediario y se ejecuta la tarea de forma asincrona
     * */
    @Override
    public void onNext(Integer item) {
        System.out.println("Recived Item: " + item);
        subscription.request(2);
        Sleeper.sleep(1000);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Print subscriber complete");
    }
}
