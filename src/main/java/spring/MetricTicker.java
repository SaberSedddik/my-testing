package spring;

import com.codahale.metrics.Counter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by saberseddik on 15-02-02.
 */
public class MetricTicker implements InitializingBean {

    private static final Logger logger = LoggerFactory.getLogger(MetricTicker.class);

    private MetricRegistry metricRegistry;
    private Counter counter;
    private Timer timer;
    private ScheduledExecutorService executor;


    @Override
    public void afterPropertiesSet() throws Exception {
        counter = metricRegistry.counter("mycounter");
        timer = metricRegistry.timer("myTimer");
        executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                logger.info("incrementing Counter");
                counter.inc();
                logger.info(" current value is " + counter.getCount());
            }
        }, 0, 10, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                logger.info("staring timer");
                Timer.Context context = timer.time();
                int x = random.nextInt(1000);
                try {
                    Thread.sleep(x);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                long time = context.stop();
                logger.info(" processing took " + time);
            }
        }, 5, 10, TimeUnit.SECONDS);
    }

    public void setMetricRegistry(MetricRegistry metricRegistry) {
        this.metricRegistry = metricRegistry;
    }


}
