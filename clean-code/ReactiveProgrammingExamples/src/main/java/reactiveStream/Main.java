package reactiveStream;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        /**
         * Hace las veces del observador esta pendiente de lo que esta sucediendo----------
         *
         * ->SubmissionPublisher es una fuente de flujo de datos....
         * **/
        SubmissionPublisher<Integer> submissionPublisher = new SubmissionPublisher<Integer>();

        /**
         * procesamiento de datos que estaran siendo Observados
         *
         * ->intermediario que hace una transformacion de los flujos de datos
         * **/
        Flow.Processor<Integer,Integer> powProcessor = new PowProcessor();

        /**
         * subscribe el Objeto que va se observado
         *
         * ->luego de procesar los datos se convierte en una fuente de flujo de datos
         * */
        Flow.Subscriber<Integer> printSubscriber = new PrintSubscriber();


        powProcessor.subscribe(printSubscriber);

        submissionPublisher.subscribe(powProcessor);

        IntStream.range(0,20).parallel().forEach((i)->{
            submissionPublisher.submit(i);
            Sleeper.sleep(2000);
        });

        /**
         *Cierra el publicador
         * se llama al oncomplete del flujo y termina el flujo
         * **/
        submissionPublisher.close();

    }
}
