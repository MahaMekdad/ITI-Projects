package org.example.customUtils.customScope;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ScopeMetadata;
import org.springframework.context.annotation.ScopeMetadataResolver;

public class CustomScope implements ScopeMetadataResolver {

    @Override
    public ScopeMetadata resolveScopeMetadata(BeanDefinition arg0) {
        System.out.println("Inside the scope resolver method when creating " + arg0.getBeanClassName() + " <---");
        ScopeMetadata scopeMetadata;
        if(arg0.isSingleton()){
            arg0.setScope("prototype");
            scopeMetadata = new ScopeMetadata();
            scopeMetadata.setScopeName(BeanDefinition.SCOPE_PROTOTYPE);
        }
        else {
            scopeMetadata = new ScopeMetadata();
        }
        return scopeMetadata;
    }
    
}
