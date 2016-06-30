package br.com.zup.spring.kafka.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsumerQueueConfig {
    
    @Value("${CONSUMER_BOOTSTRAP_SERVERS:${consumer.bootstrap.servers}}")
    private String bootstrapServers;
    
    @Value("${CONSUMER_KEY_DESERIALIZER:${consumer.key.deserializer}}")
    private String keyDeserializer;
    
    @Value("${CONSUMER_VALUE_DESERIALIZER:${consumer.value.deserializer}}")
    private String valueDeserializer;
    
    @Value("${CONSUMER_FETCH_MIN_BYTES:${consumer.fetch.min.bytes}}")
    private String fetchMinBytes;
    
    @Value("${CONSUMER_GROUP_ID:${consumer.group.id}}")
    private String groupId;
    
    @Value("${CONSUMER_HEARTBEAT_INTERVAL_MS:${consumer.heartbeat.interval.ms}}")
    private String heartbeatIntervalMs;
    
    @Value("${CONSUMER_MAX_PARTITION_FETCH_BYTES:${consumer.max.partition.fetch.bytes}}")
    private String maxPartitionFetchBytes;
    
    @Value("${CONSUMER_SESSION_TIMEOUT_MS:${consumer.session.timeout.ms}}")
    private String sessionTimeoutMs;
    
    @Value("${CONSUMER_SSL_KEY_PASSWORD:${consumer.ssl.key.password}}")
    private String sslKeyPassword;
    
    @Value("${CONSUMER_SSL_KEYSTORE_LOCATION:${consumer.ssl.keystore.location}}")
    private String sslKeystoreLocation;
    
    @Value("${CONSUMER_SSL_KEYSTORE_PASSWORD:${consumer.ssl.keystore.password}}")
    private String sslKeystorePassword;
    
    @Value("${CONSUMER_SSL_TRUSTSTORE_LOCATION:${consumer.ssl.truststore.location}}")
    private String sslTruststoreLocation;
    
    @Value("${CONSUMER_SSL_TRUSTSTORE_PASSWORD:${consumer.ssl.truststore.password}}")
    private String sslTruststorePassword;
    
    @Value("${CONSUMER_AUTO_OFFSET_RESET:${consumer.auto.offset.reset}}")
    private String autoOffsetReset;
    
    @Value("${CONSUMER_CONNECTIONS_MAX_IDLE_MS:${consumer.connections.max.idle.ms}}")
    private String connectionsMaxIdleMs;
    
    @Value("${CONSUMER_ENABLE_AUTO_COMMIT:${consumer.enable.auto.commit}}")
    private String enableAutoCommit;
    
    @Value("${CONSUMER_PARTITION_ASSIGNMENT_STRATEGY:${consumer.partition.assignment.strategy}}")
    private String partitionAssignmentStrategy;
    
    @Value("${CONSUMER_RECEIVE_BUFFER_BYTES:${consumer.receive.buffer.bytes}}")
    private String receiveBufferBytes;
    
    @Value("${CONSUMER_REQUEST_TIMEOUT_MS:${consumer.request.timeout.ms}}")
    private String requestTimeoutMs;
    
    @Value("${CONSUMER_SASL_KERBEROS_SERVICE_NAME:${consumer.sasl.kerberos.service.name}}")
    private String saslKerberosServiceName;
    
    @Value("${CONSUMER_SECURITY_PROTOCOL:${consumer.security.protocol}}")
    private String securityProtocol;
    
    @Value("${CONSUMER_SEND_BUFFER_BYTES:${consumer.send.buffer.bytes}}")
    private String sendBufferBytes;
    
    @Value("${CONSUMER_SSL_ENABLED_PROTOCOLS:${consumer.ssl.enabled.protocols}}")
    private String sslEnabledProtocols;
    
    @Value("${CONSUMER_SSL_KEYSTORE_TYPE:${consumer.ssl.keystore.type}}")
    private String sslKeystoreType;
    
    @Value("${CONSUMER_SSL_PROTOCOL:${consumer.ssl.protocol}}")
    private String sslProtocol;
    
    @Value("${CONSUMER_SSL_PROVIDER:${consumer.ssl.provider}}")
    private String sslProvider;
    
    @Value("${CONSUMER_SSL_TRUSTSTORE_TYPE:${consumer.ssl.truststore.type}}")
    private String sslTruststoreType;
    
    @Value("${CONSUMER_AUTO_COMMIT_INTERVAL_MS:${consumer.auto.commit.interval.ms}}")
    private String autoCommitIntervalMs;
    
    @Value("${CONSUMER_CHECK_CRCS:${consumer.check.crcs}}")
    private String checkCrcs;
    
    @Value("${CONSUMER_CLIENT_ID:${consumer.client.id}}")
    private String clientId;
    
    @Value("${CONSUMER_FETCH_MAX_WAIT_MS:${consumer.fetch.max.wait.ms}}")
    private String fetchMaxWaitMs;
    
    @Value("${CONSUMER_METADATA_MAX_AGE_MS:${consumer.metadata.max.age.ms}}")
    private String metadataMaxAgeMs;
    
    @Value("${CONSUMER_METRIC_REPORTERS:${consumer.metric.reporters}}")
    private String metricReporters;
    
    @Value("${CONSUMER_METRICS_NUM_SAMPLES:${consumer.metrics.num.samples}}")
    private String metricsNumSamples;
    
    @Value("${CONSUMER_METRICS_SAMPLE_WINDOW_MS:${consumer.metrics.sample.window.ms}}")
    private String metricsSampleWindowMs;
    
    @Value("${CONSUMER_RECONNECT_BACKOFF_MS:${consumer.reconnect.backoff.ms}}")
    private String reconnectBackoffMs;
    
    @Value("${CONSUMER_RETRY_BACKOFF_MS:${consumer.retry.backoff.ms}}")
    private String retryBackoffMs;
    
    @Value("${CONSUMER_SASL_KERBEROS_KINIT_CMD:${consumer.sasl.kerberos.kinit.cmd}}")
    private String saslKerberosKinitCmd;
    
    @Value("${CONSUMER_SASL_KERBEROS_MIN_TIME_BEFORE_RELOGIN:${consumer.sasl.kerberos.min.time.before.relogin}}")
    private String saslKerberosMinTimeBeforeRelogin;
    
    @Value("${CONSUMER_SASL_KERBEROS_TICKET_RENEW_JITTER:${consumer.sasl.kerberos.ticket.renew.jitter}}")
    private String saslKerberosTicketRenewJitter;
    
    @Value("${CONSUMER_SASL_KERBEROS_TICKET_RENEW_WINDOW_FACTOR:${consumer.sasl.kerberos.ticket.renew.window.factor}}")
    private String saslKerberosTicketRenewWindowFactor;
    
    @Value("${CONSUMER_SSL_CIPHER_SUITES:${consumer.ssl.cipher.suites}}")
    private String sslCipherSuites;
    
    @Value("${CONSUMER_SSL_ENDPOINT_IDENTIFICATION_ALGORITHM:${consumer.ssl.endpoint.identification.algorithm}}")
    private String sslEndpointIdentificationAlgorithm;
    
    @Value("${CONSUMER_SSL_KEYMANAGER_ALGORITHM:${consumer.ssl.keymanager.algorithm}}")
    private String sslKeymanagerAlgorithm;
    
    @Value("${CONSUMER_SSL_TRUSTMANAGER_ALGORITHM:${consumer.ssl.trustmanager.algorithm}}")
    private String sslTrustmanagerAlgorithm;
    
    @Value("${CONSUMER_DESERIALIZER_CLASS:${consumer.deserializer.class}}")
    private String deserializerClass;
    

    public String getBootstrapServers() {
        return bootstrapServers;
    }

    public String getKeyDeserializer() {
        return keyDeserializer;
    }

    public String getValueDeserializer() {
        return valueDeserializer;
    }

    public String getFetchMinBytes() {
        return fetchMinBytes;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getHeartbeatIntervalMs() {
        return heartbeatIntervalMs;
    }

    public String getMaxPartitionFetchBytes() {
        return maxPartitionFetchBytes;
    }

    public String getSessionTimeoutMs() {
        return sessionTimeoutMs;
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

    public String getAutoOffsetReset() {
        return autoOffsetReset;
    }

    public String getConnectionsMaxIdleMs() {
        return connectionsMaxIdleMs;
    }

    public String getEnableAutoCommit() {
        return enableAutoCommit;
    }

    public String getPartitionAssignmentStrategy() {
        return partitionAssignmentStrategy;
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

    public String getAutoCommitIntervalMs() {
        return autoCommitIntervalMs;
    }

    public String getCheckCrcs() {
        return checkCrcs;
    }

    public String getClientId() {
        return clientId;
    }

    public String getFetchMaxWaitMs() {
        return fetchMaxWaitMs;
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

    public String getDeserializerClass() {
        return deserializerClass;
    }
}