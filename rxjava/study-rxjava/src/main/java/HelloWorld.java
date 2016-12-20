import org.junit.Test;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;

/**
 * Created by wangqinghui on 2016/10/18.
 */
public class HelloWorld {

    @Test
    public void basic() {
        Observable<String> myObservable = Observable.create(
                new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> sub) {
                        sub.onNext("Hello, world!");
                        sub.onCompleted();
                    }
                }
        )
                .doOnTerminate(new Action0() {
                    @Override
                    public void call() {
                        System.out.println("end");
                    }
                })
                .lift(new Observable.Operator<String, String>() {
                    @Override
                    public Subscriber<? super String> call(Subscriber<? super String> subscriber) {
                        return new Subscriber<String>() {
                            @Override
                            public void onCompleted() {
                                System.out.println("lift end");
                                subscriber.onCompleted();
                            }

                            @Override
                            public void onError(Throwable throwable) {

                            }

                            @Override
                            public void onNext(String s) {
                                System.out.println("lift " + s);
                                subscriber.onNext(s);
                            }
                        };
                    }
                });

        Subscriber<String> mySubscriber = new Subscriber<String>() {
            @Override
            public void onNext(String s) {
                System.out.println("sub " + s);
            }

            @Override
            public void onCompleted() {
                System.out.println("sub end");
            }

            @Override
            public void onError(Throwable e) {
            }
        };

        myObservable.subscribe(mySubscriber);

    }

    @Test
    public void basic2() {
        Observable<String> myObservable = Observable.just("Hello, world!");

        Action1<String> onNextAction = new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        };

        myObservable.subscribe(onNextAction);

    }

    @Test
    public void basic3() {
        Observable.just("Hello, world!")
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println(s);
                    }
                });
    }


    @Test
    public void basic4() {
        Observable.just("Hello, world!")
                .subscribe(s -> System.out.println(s));
    }


}
