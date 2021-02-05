package reactiveStream;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class PowProcessor extends SubmissionPublisher<Integer> implements Flow.Processor<Integer,Integer> {

    private Flow.Subscription subscription;

    //conexion con la fuente de flujo de datos
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(2);
    }

    /**
     * Procesa los datos que vienen del flujo de datos
     * */
    @Override
    public void onNext(Integer item) {
        /*** endica los datos al consumidor*/
        submit(item * item);

        /**
         * controla la cantidad de datos y se gestionan los hilos
         * **/
        subscription.request(2);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("pow processor complete");
        close();
    }
}
