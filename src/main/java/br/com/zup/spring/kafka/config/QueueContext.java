package br.com.zup.spring.kafka.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import br.com.zup.spring.kafka.util.PropertiesUtils;

@Configuration
@PropertySource(value = {"classpath:kafka-producer-default.properties", "classpath:kafka-producer.properties", 
    "classpath:kafka-consumer-default.properties", "kafka-consumer.properties"}, ignoreResourceNotFound = true)
@ImportResource(locations = {"classpath:kafka-context.xml"})
public class QueueContext {
    
    @Autowired
    private ProducerQueueConfig producerQueueConfig;
    
    @Autowired
    private ConsumerQueueConfig consumerQueueConfig;
    
    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer a = new PropertySourcesPlaceholderConfigurer();
        a.setNullValue("@null");
        return a;
    }
    
    @Bean(name="producerConfig")
    public Properties producerProperties() {
        Properties props = new Properties();
        PropertiesUtils.putIfValid(props, "bootstrap.servers", producerQueueConfig.getBootstrapServers());
        PropertiesUtils.putIfValid(props, "key.serializer", producerQueueConfig.getKeySerializer());
        PropertiesUtils.putIfValid(props, "value.serializer", producerQueueConfig.getValueSerializer());
        PropertiesUtils.putIfValid(props, "acks", producerQueueConfig.getAcks());
        PropertiesUtils.putIfValid(props, "buffer.memory", producerQueueConfig.getBufferMemory());
        PropertiesUtils.putIfValid(props, "compression.type", producerQueueConfig.getCompressionType());
        PropertiesUtils.putIfValid(props, "retries", producerQueueConfig.getRetries());
        PropertiesUtils.putIfValid(props, "ssl.key.password", producerQueueConfig.getSslKeyPassword());
        PropertiesUtils.putIfValid(props, "ssl.keystore.location", producerQueueConfig.getSslKeystoreLocation());
        PropertiesUtils.putIfValid(props, "ssl.keystore.password", producerQueueConfig.getSslKeystorePassword());
        PropertiesUtils.putIfValid(props, "ssl.truststore.location", producerQueueConfig.getSslTruststoreLocation());
        PropertiesUtils.putIfValid(props, "ssl.truststore.password", producerQueueConfig.getSslTruststorePassword());
        PropertiesUtils.putIfValid(props, "batch.size", producerQueueConfig.getBatchSize());
        PropertiesUtils.putIfValid(props, "client.id", producerQueueConfig.getClientId());
        PropertiesUtils.putIfValid(props, "connections.max.idle.ms", producerQueueConfig.getConnectionsMaxIdleMs());
        PropertiesUtils.putIfValid(props, "linger.ms", producerQueueConfig.getLingerMs());
        PropertiesUtils.putIfValid(props, "max.block.ms", producerQueueConfig.getMaxBlockMs());
        PropertiesUtils.putIfValid(props, "max.request.size", producerQueueConfig.getMaxRequestSize());
        PropertiesUtils.putIfValid(props, "partitioner.class", producerQueueConfig.getPartitionerClass());
        PropertiesUtils.putIfValid(props, "receive.buffer.bytes", producerQueueConfig.getReceiveBufferBytes());
        PropertiesUtils.putIfValid(props, "request.timeout.ms", producerQueueConfig.getRequestTimeoutMs());
        PropertiesUtils.putIfValid(props, "sasl.kerberos.service.name", producerQueueConfig.getSaslKerberosServiceName());
        PropertiesUtils.putIfValid(props, "sasl.mechanism", producerQueueConfig.getSaslMechanism());
        PropertiesUtils.putIfValid(props, "security.protocol", producerQueueConfig.getSecurityProtocol());
        PropertiesUtils.putIfValid(props, "send.buffer.bytes", producerQueueConfig.getSendBufferBytes());
        PropertiesUtils.putIfValid(props, "ssl.enabled.protocols", producerQueueConfig.getSslEnabledProtocols());
        PropertiesUtils.putIfValid(props, "ssl.keystore.type", producerQueueConfig.getSslKeystoreType());
        PropertiesUtils.putIfValid(props, "ssl.protocol", producerQueueConfig.getSslProtocol());
        PropertiesUtils.putIfValid(props, "ssl.provider", producerQueueConfig.getSslProvider());
        PropertiesUtils.putIfValid(props, "ssl.truststore.type", producerQueueConfig.getSslTruststoreType());
        PropertiesUtils.putIfValid(props, "timeout.ms", producerQueueConfig.getTimeoutMs());
        PropertiesUtils.putIfValid(props, "block.on.buffer.full", producerQueueConfig.getBlockOnBufferFull());
        PropertiesUtils.putIfValid(props, "interceptor.classes", producerQueueConfig.getInterceptorClasses());
        PropertiesUtils.putIfValid(props, "max.in.flight.requests.per.connection", producerQueueConfig.getMaxInFlightRequestsPerConnection());
        PropertiesUtils.putIfValid(props, "metadata.fetch.timeout.ms", producerQueueConfig.getMetadataFetchTimeoutMs());
        PropertiesUtils.putIfValid(props, "metadata.max.age.ms", producerQueueConfig.getMetadataMaxAgeMs());
        PropertiesUtils.putIfValid(props, "metric.reporters", producerQueueConfig.getMetricReporters());
        PropertiesUtils.putIfValid(props, "metrics.num.samples", producerQueueConfig.getMetricsNumSamples());
        PropertiesUtils.putIfValid(props, "metrics.sample.window.ms", producerQueueConfig.getMetricsSampleWindowMs());
        PropertiesUtils.putIfValid(props, "reconnect.backoff.ms", producerQueueConfig.getReconnectBackoffMs());
        PropertiesUtils.putIfValid(props, "retry.backoff.ms", producerQueueConfig.getRetryBackoffMs());
        PropertiesUtils.putIfValid(props, "sasl.kerberos.kinit.cmd", producerQueueConfig.getSaslKerberosKinitCmd());
        PropertiesUtils.putIfValid(props, "sasl.kerberos.min.time.before.relogin", producerQueueConfig.getSaslKerberosMinTimeBeforeRelogin());
        PropertiesUtils.putIfValid(props, "sasl.kerberos.ticket.renew.jitter", producerQueueConfig.getSaslKerberosTicketRenewJitter());
        PropertiesUtils.putIfValid(props, "sasl.kerberos.ticket.renew.window.factor", producerQueueConfig.getSaslKerberosTicketRenewWindowFactor());
        PropertiesUtils.putIfValid(props, "ssl.cipher.suites", producerQueueConfig.getSslCipherSuites());
        PropertiesUtils.putIfValid(props, "ssl.endpoint.identification.algorithm", producerQueueConfig.getSslEndpointIdentificationAlgorithm());
        PropertiesUtils.putIfValid(props, "ssl.keymanager.algorithm", producerQueueConfig.getSslKeymanagerAlgorithm());
        PropertiesUtils.putIfValid(props, "ssl.trustmanager.algorithm", producerQueueConfig.getSslTrustmanagerAlgorithm());
        return props;
    }
    
    @Bean(name="consumerConfig")
    public Properties consumerProperties() {
        Properties props = new Properties();
        PropertiesUtils.putIfValid(props, "bootstrap.servers", consumerQueueConfig.getBootstrapServers());
        PropertiesUtils.putIfValid(props, "key.deserializer", consumerQueueConfig.getKeyDeserializer());
        PropertiesUtils.putIfValid(props, "value.deserializer", consumerQueueConfig.getValueDeserializer());
        PropertiesUtils.putIfValid(props, "fetch.min.bytes", consumerQueueConfig.getFetchMinBytes());
        PropertiesUtils.putIfValid(props, "group.id", consumerQueueConfig.getGroupId());
        PropertiesUtils.putIfValid(props, "heartbeat.interval.ms", consumerQueueConfig.getHeartbeatIntervalMs());
        PropertiesUtils.putIfValid(props, "max.partition.fetch.bytes", consumerQueueConfig.getMaxPartitionFetchBytes());
        PropertiesUtils.putIfValid(props, "session.timeout.ms", consumerQueueConfig.getSessionTimeoutMs());
        PropertiesUtils.putIfValid(props, "ssl.key.password", consumerQueueConfig.getSslKeyPassword());
        PropertiesUtils.putIfValid(props, "ssl.keystore.location", consumerQueueConfig.getSslKeystoreLocation());
        PropertiesUtils.putIfValid(props, "ssl.keystore.password", consumerQueueConfig.getSslKeystorePassword());
        PropertiesUtils.putIfValid(props, "ssl.truststore.location", consumerQueueConfig.getSslTruststoreLocation());
        PropertiesUtils.putIfValid(props, "ssl.truststore.password", consumerQueueConfig.getSslTruststorePassword());
        PropertiesUtils.putIfValid(props, "auto.offset.reset", consumerQueueConfig.getAutoOffsetReset());
        PropertiesUtils.putIfValid(props, "connections.max.idle.ms", consumerQueueConfig.getConnectionsMaxIdleMs());
        PropertiesUtils.putIfValid(props, "enable.auto.commit", consumerQueueConfig.getEnableAutoCommit());
        PropertiesUtils.putIfValid(props, "partition.assignment.strategy", consumerQueueConfig.getPartitionAssignmentStrategy());
        PropertiesUtils.putIfValid(props, "receive.buffer.bytes", consumerQueueConfig.getReceiveBufferBytes());
        PropertiesUtils.putIfValid(props, "request.timeout.ms", consumerQueueConfig.getRequestTimeoutMs());
        PropertiesUtils.putIfValid(props, "sasl.kerberos.service.name", consumerQueueConfig.getSaslKerberosServiceName());
        PropertiesUtils.putIfValid(props, "security.protocol", consumerQueueConfig.getSecurityProtocol());
        PropertiesUtils.putIfValid(props, "send.buffer.bytes", consumerQueueConfig.getSendBufferBytes());
        PropertiesUtils.putIfValid(props, "ssl.enabled.protocols", consumerQueueConfig.getSslEnabledProtocols());
        PropertiesUtils.putIfValid(props, "ssl.keystore.type", consumerQueueConfig.getSslKeystoreType());
        PropertiesUtils.putIfValid(props, "ssl.protocol", consumerQueueConfig.getSslProtocol());
        PropertiesUtils.putIfValid(props, "ssl.provider", consumerQueueConfig.getSslProvider());
        PropertiesUtils.putIfValid(props, "ssl.truststore.type", consumerQueueConfig.getSslTruststoreType());
        PropertiesUtils.putIfValid(props, "auto.commit.interval.ms", consumerQueueConfig.getAutoCommitIntervalMs());
        PropertiesUtils.putIfValid(props, "check.crcs", consumerQueueConfig.getCheckCrcs());
        PropertiesUtils.putIfValid(props, "client.id", consumerQueueConfig.getClientId());
        PropertiesUtils.putIfValid(props, "fetch.max.wait.ms", consumerQueueConfig.getFetchMaxWaitMs());
        PropertiesUtils.putIfValid(props, "metadata.max.age.ms", consumerQueueConfig.getMetadataMaxAgeMs());
        PropertiesUtils.putIfValid(props, "metric.reporters", consumerQueueConfig.getMetricReporters());
        PropertiesUtils.putIfValid(props, "metrics.num.samples", consumerQueueConfig.getMetricsNumSamples());
        PropertiesUtils.putIfValid(props, "metrics.sample.window.ms", consumerQueueConfig.getMetricsSampleWindowMs());
        PropertiesUtils.putIfValid(props, "reconnect.backoff.ms", consumerQueueConfig.getReconnectBackoffMs());
        PropertiesUtils.putIfValid(props, "retry.backoff.ms", consumerQueueConfig.getRetryBackoffMs());
        PropertiesUtils.putIfValid(props, "sasl.kerberos.kinit.cmd", consumerQueueConfig.getSaslKerberosKinitCmd());
        PropertiesUtils.putIfValid(props, "sasl.kerberos.min.time.before.relogin", consumerQueueConfig.getSaslKerberosMinTimeBeforeRelogin());
        PropertiesUtils.putIfValid(props, "sasl.kerberos.ticket.renew.jitter", consumerQueueConfig.getSaslKerberosTicketRenewJitter());
        PropertiesUtils.putIfValid(props, "sasl.kerberos.ticket.renew.window.factor", consumerQueueConfig.getSaslKerberosTicketRenewWindowFactor());
        PropertiesUtils.putIfValid(props, "ssl.cipher.suites", consumerQueueConfig.getSslCipherSuites());
        PropertiesUtils.putIfValid(props, "ssl.endpoint.identification.algorithm", consumerQueueConfig.getSslEndpointIdentificationAlgorithm());
        PropertiesUtils.putIfValid(props, "ssl.keymanager.algorithm", consumerQueueConfig.getSslKeymanagerAlgorithm());
        PropertiesUtils.putIfValid(props, "ssl.trustmanager.algorithm", consumerQueueConfig.getSslTrustmanagerAlgorithm());
        PropertiesUtils.putIfValid(props, "deserializer.class", consumerQueueConfig.getDeserializerClass());
        return props;
    }
    
}