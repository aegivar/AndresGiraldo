package reactiveStream;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        /**
         * Hace las veces del observador esta pendiente de lo que esta sucediendo
         * **/
        SubmissionPublisher<Integer> submissionPublisher = new SubmissionPublisher<Integer>();

        /**
         * procesamiento de datos que estaran siendo Observados
         * **/
        Flow.Processor<Integer,Integer> powProcessor = new PowProcessor();

        /**
         * subscribe el Objeto que va se observado
         * */
        Flow.Subscriber<Integer> printSubscriber = new PrintSubscriber();

        powProcessor.subscribe(printSubscriber);
        submissionPublisher.subscribe(powProcessor);

        IntStream.range(0,20).forEach((i)->{
            submissionPublisher.submit(i);
            Sleeper.sleep(2000);
        });

        /**
         *Cierra el publicador
         * **/
        submissionPublisher.close();

    }
}
