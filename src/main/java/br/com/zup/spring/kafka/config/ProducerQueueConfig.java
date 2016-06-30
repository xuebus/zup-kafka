package br.com.zup.spring.kafka.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerQueueConfig {
    
    @Value("${PRODUCER_BOOTSTRAP_SERVERS:${producer.bootstrap.servers}}")
    private String bootstrapServers;

    @Value("${PRODUCER_KEY_SERIALIZER:${producer.key.serializer}}")
    private String keySerializer;
    
    @Value("${PRODUCER_VALUE_SERIALIZER:${producer.value.serializer}}")
    private String valueSerializer;
    
    @Value("${PRODUCER_ACKS:${producer.acks}}")
    private String acks;
    
    @Value("${PRODUCER_BUFFER_MEMORY:${producer.buffer.memory}}")
    private String bufferMemory;
    
    @Value("${PRODUCER_COMPRESSION_TYPE:${producer.compression.type}}")
    private String compressionType;

    @Value("${PRODUCER_RETRIES:${producer.retries}}")
    private String retries;
    
    @Value("${PRODUCER_SSL_KEY_PASSWORD:${producer.ssl.key.password}}")
    private String sslKeyPassword;
    
    @Value("${PRODUCER_SSL_KEYSTORE_LOCATION:${producer.ssl.keystore.location}}")
    private String sslKeystoreLocation;
    
    @Value("${PRODUCER_SSL_KEYSTORE_PASSWORD:${producer.ssl.keystore.password}}")
    private String sslKeystorePassword;
    
    @Value("${PRODUCER_SSL_TRUSTSTORE_LOCATION:${producer.ssl.truststore.location}}")
    private String sslTruststoreLocation;
    
    @Value("${PRODUCER_SSL_TRUSTSTORE_PASSWORD:${producer.ssl.truststore.password}}")
    private String sslTruststorePassword;

    @Value("${PRODUCER_BATCH_SIZE:${producer.batch.size}}")
    private Integer batchSize;
    
    @Value("${PRODUCER_CLIENT_ID:${producer.client.id}}")
    private String clientId;
    
    @Value("${PRODUCER_CONNECTIONS_MAX_IDLE_MS:${producer.connections.max.idle.ms}}")
    private String connectionsMaxIdleMs;

    @Value("${PRODUCER_LINGER_MS:${producer.linger.ms}}")
    private String lingerMs;
    
    @Value("${PRODUCER_MAX_BLOCK_MS:${producer.max.block.ms}}")
    private String maxBlockMs;
    
    @Value("${PRODUCER_MAX_REQUEST_SIZE:${producer.max.request.size}}")
    private String maxRequestSize;
    
    @Value("${PRODUCER_PARTITIONER_CLASS:${producer.partitioner.class}}")
    private String partitionerClass;
    
    @Value("${PRODUCER_RECEIVE_BUFFER_BYTES:${producer.receive.buffer.bytes}}")
    private String receiveBufferBytes;

    @Value("${PRODUCER_REQUEST_TIMEOUT_MS:${producer.request.timeout.ms}}")
    private String requestTimeoutMs;
    
    @Value("${PRODUCER_SASL_KERBEROS_SERVICE_NAME:${producer.sasl.kerberos.service.name}}")
    private String saslKerberosServiceName;
    
    @Value("${PRODUCER_SASL_MECHANISM:${producer.sasl.mechanism}}")
    private String saslMechanism;
    
    @Value("${PRODUCER_SECURITY_PROTOCOL:${producer.security.protocol}}")
    private String securityProtocol;
    
    @Value("${PRODUCER_SEND_BUFFER_BYTES:${producer.send.buffer.bytes}}")
    private String sendBufferBytes;
    
    @Value("${PRODUCER_SSL_ENABLED_PROTOCOLS:${producer.ssl.enabled.protocols}}")
    private String sslEnabledProtocols;
    
    @Value("${PRODUCER_SSL_KEYSTORE_TYPE:${producer.ssl.keystore.type}}")
    private String sslKeystoreType;
    
    @Value("${PRODUCER_SSL_PROTOCOL:${producer.ssl.protocol}}")
    private String sslProtocol;
    
    @Value("${PRODUCER_SSL_PROVIDER:${producer.ssl.provider}}")
    private String sslProvider;
    
    @Value("${PRODUCER_SSL_TRUSTSTORE_TYPE:${producer.ssl.truststore.type}}")
    private String sslTruststoreType;
    
    @Value("${PRODUCER_TIMEOUT_MS:${producer.timeout.ms}}")
    private String timeoutMs;
    
    @Value("${PRODUCER_BLOCK_ON_BUFFER_FULL:${producer.block.on.buffer.full}}")
    private String blockOnBufferFull;
    
    @Value("${PRODUCER_INTERCEPTOR_CLASSES:${producer.interceptor.classes}}")
    private String interceptorClasses;
    
    @Value("${PRODUCER_MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION:${producer.max.in.flight.requests.per.connection}}")
    private String maxInFlightRequestsPerConnection;
    
    @Value("${PRODUCER_METADATA_FETCH_TIMEOUT_MS:${producer.metadata.fetch.timeout.ms}}")
    private String metadataFetchTimeoutMs;
    
    @Value("${PRODUCER_METADATA_MAX_AGE_MS:${producer.metadata.max.age.ms}}")
    private String metadataMaxAgeMs;
    
    @Value("${PRODUCER_METRIC_REPORTERS:${producer.metric.reporters}}")
    private String metricReporters;
    
    @Value("${PRODUCER_METRICS_NUM_SAMPLES:${producer.metrics.num.samples}}")
    private String metricsNumSamples;
    
    @Value("${PRODUCER_METRICS_SAMPLE_WINDOW_MS:${producer.metrics.sample.window.ms}}")
    private String metricsSampleWindowMs;
    
    @Value("${PRODUCER_RECONNECT_BACKOFF_MS:${producer.reconnect.backoff.ms}}")
    private String reconnectBackoffMs;
    
    @Value("${PRODUCER_RETRY_BACKOFF_MS:${producer.retry.backoff.ms}}")
    private String retryBackoffMs;
    
    @Value("${PRODUCER_SASL_KERBEROS_KINIT_CMD:${producer.sasl.kerberos.kinit.cmd}}")
    private String saslKerberosKinitCmd;
    
    @Value("${PRODUCER_SASL_KERBEROS_MIN_TIME_BEFORE_RELOGIN:${producer.sasl.kerberos.min.time.before.relogin}}")
    private String saslKerberosMinTimeBeforeRelogin;
    
    @Value("${PRODUCER_SASL_KERBEROS_TICKET_RENEW_JITTER:${producer.sasl.kerberos.ticket.renew.jitter}}")
    private String saslKerberosTicketRenewJitter;
    
    @Value("${PRODUCER_SASL_KERBEROS_TICKET_RENEW_WINDOW_FACTOR:${producer.sasl.kerberos.ticket.renew.window.factor}}")
    private String saslKerberosTicketRenewWindowFactor;
    
    @Value("${PRODUCER_SSL_CIPHER_SUITES:${producer.ssl.cipher.suites}}")
    private String sslCipherSuites;
    
    @Value("${PRODUCER_SSL_ENDPOINT_IDENTIFICATION_ALGORITHM:${producer.ssl.endpoint.identification.algorithm}}")
    private String sslEndpointIdentificationAlgorithm;
    
    @Value("${PRODUCER_SSL_KEYMANAGER_ALGORITHM:${producer.ssl.keymanager.algorithm}}")
    private String sslKeymanagerAlgorithm;
    
    @Value("${PRODUCER_SSL_TRUSTMANAGER_ALGORITHM:${producer.ssl.trustmanager.algorithm}}")
    private String sslTrustmanagerAlgorithm;

    public String getBootstrapServers() {
        return bootstrapServers;
    }

    public String getKeySerializer() {
        return keySerializer;
    }

    public String getValueSerializer() {
        return valueSerializer;
    }

    public String getAcks() {
        return acks;
    }

    public String getBufferMemory() {
        return bufferMemory;
    }

    public String getCompressionType() {
        return compressionType;
    }

    public String getRetries() {
        return retries;
    }

    public String getSslKeyPassword() {
        return sslKeyPassword;
    }

    public String getSslKeystoreLocation() {
        return sslKeystoreLocation;
    }

    public String getSslKeystorePassword() {
        return sslKeystorePassword;
    }

    public String getSslTruststoreLocation() {
        return sslTruststoreLocation;
    }

    public String getSslTruststorePassword() {
        return sslTruststorePassword;
    }

    public Integer getBatchSize() {
        return batchSize;
    }

    public String getClientId() {
        return clientId;
    }

    public String getConnectionsMaxIdleMs() {
        return connectionsMaxIdleMs;
    }

    public String getLingerMs() {
        return lingerMs;
    }

    public String getMaxBlockMs() {
        return maxBlockMs;
    }

    public String getMaxRequestSize() {
        return maxRequestSize;
    }

    public String getPartitionerClass() {
        return partitionerClass;
    }

    public String getReceiveBufferBytes() {
        return receiveBufferBytes;
    }

    public String getRequestTimeoutMs() {
        return requestTimeoutMs;
    }

    public String getSaslKerberosServiceName() {
        return saslKerberosServiceName;
    }

    public String getSaslMechanism() {
        return saslMechanism;
    }

    public String getSecurityProtocol() {
        return securityProtocol;
    }

    public String getSendBufferBytes() {
        return sendBufferBytes;
    }

    public String getSslEnabledProtocols() {
        return sslEnabledProtocols;
    }

    public String getSslKeystoreType() {
        return sslKeystoreType;
    }

    public String getSslProtocol() {
        return sslProtocol;
    }

    public String getSslProvider() {
        return sslProvider;
    }

    public String getSslTruststoreType() {
        return sslTruststoreType;
    }

    public String getTimeoutMs() {
        return timeoutMs;
    }

    public String getBlockOnBufferFull() {
        return blockOnBufferFull;
    }

    public String getInterceptorClasses() {
        return interceptorClasses;
    }

    public String getMaxInFlightRequestsPerConnection() {
        return maxInFlightRequestsPerConnection;
    }

    public String getMetadataFetchTimeoutMs() {
        return metadataFetchTimeoutMs;
    }

    public String getMetadataMaxAgeMs() {
        return metadataMaxAgeMs;
    }

    public String getMetricReporters() {
        return metricReporters;
    }

    public String getMetricsNumSamples() {
        return metricsNumSamples;
    }

    public String getMetricsSampleWindowMs() {
        return metricsSampleWindowMs;
    }

    public String getReconnectBackoffMs() {
        return reconnectBackoffMs;
    }

    public String getRetryBackoffMs() {
        return retryBackoffMs;
    }

    public String getSaslKerberosKinitCmd() {
        return saslKerberosKinitCmd;
    }

    public String getSaslKerberosMinTimeBeforeRelogin() {
        return saslKerberosMinTimeBeforeRelogin;
    }

    public String getSaslKerberosTicketRenewJitter() {
        return saslKerberosTicketRenewJitter;
    }

    public String getSaslKerberosTicketRenewWindowFactor() {
        return saslKerberosTicketRenewWindowFactor;
    }

    public String getSslCipherSuites() {
        return sslCipherSuites;
    }

    public String getSslEndpointIdentificationAlgorithm() {
        return sslEndpointIdentificationAlgorithm;
    }

    public String getSslKeymanagerAlgorithm() {
        return sslKeymanagerAlgorithm;
    }

    public String getSslTrustmanagerAlgorithm() {
        return sslTrustmanagerAlgorithm;
    }
}