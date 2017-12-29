package org.ming.humanresource.metrics;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.ScheduledReporter;
import com.codahale.metrics.health.HealthCheckRegistry;
import com.ryantenney.metrics.spring.config.annotation.EnableMetrics;
import com.ryantenney.metrics.spring.config.annotation.MetricsConfigurer;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * Metric监控配置文件
 *
 * @author MingXiangjun
 * @create 2017-12-17 19:12
 */
//@Configuration
//@EnableMetrics
public class MetricsConfig implements MetricsConfigurer {
    // 注册器
    private MetricRegistry metricRegistry;

    @Override
    public void configureReporters(MetricRegistry metricRegistry) {
        // 控制台输出
        ConsoleReporter consoleReporter = ConsoleReporter.forRegistry(metricRegistry).convertRatesTo(TimeUnit.SECONDS).convertDurationsTo(TimeUnit.SECONDS).build();
        consoleReporter.start(30,TimeUnit.SECONDS);
    }

    @Override
    public MetricRegistry getMetricRegistry() {
        if (metricRegistry == null) {
            metricRegistry = new MetricRegistry();
        }
        return metricRegistry;
    }

    @Override
    public HealthCheckRegistry getHealthCheckRegistry() {
        return null;
    }
}
