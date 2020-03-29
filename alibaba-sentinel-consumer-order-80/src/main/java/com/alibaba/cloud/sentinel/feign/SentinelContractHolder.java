package com.alibaba.cloud.sentinel.feign;

import feign.Contract;
import feign.MethodMetadata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 随着Spring Cloud Alibaba 2.2.0.RELEASE的发布，终于可以使用最新的Spring Boot和Spring Cloud
 * 但是在整合sentinel和openfeign的时候会出现启动异常
 * com.alibaba.cloud.sentinel.feign.SentinelContractHolder.parseAndValidateMetadata(Ljava/lang/Class;)L
 * 添加该类作为解决
 *
 * @author Lin Kun
 * @create 2020/3/29
 */
public class SentinelContractHolder implements Contract {

    private final Contract delegate;

    /**
     * map key is constructed by ClassFullName + configKey. configKey is constructed by
     * {@link feign.Feign#configKey}
     */
    private final static Map<String, MethodMetadata> METADATA_MAP = new HashMap<>();

    public SentinelContractHolder(Contract delegate) {
        this.delegate = delegate;
    }

    @Override
    public List<MethodMetadata> parseAndValidateMetadata(Class<?> targetType) {
        List<MethodMetadata> metaDataList = delegate.parseAndValidateMetadata(targetType);
        metaDataList.forEach(metadata -> METADATA_MAP
            .put(targetType.getName() + metadata.configKey(), metadata));
        return metaDataList;
    }

}
