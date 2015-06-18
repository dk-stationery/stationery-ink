package org.tommy.stationery.ink.core.bus.subscriber;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;
import org.tommy.stationery.ink.core.bus.event.ValidateEvent;
import org.tommy.stationery.ink.core.storm.build.validator.ISimpleStatementMetaValidator;
import org.tommy.stationery.ink.core.storm.build.validator.SimpleStatementValidatorFactory;
import org.tommy.stationery.ink.exception.InkException;

/**
 * Created by kun7788 on 15. 6. 17..
 */
public class ValidateEventHandler {

    @Subscribe
    @AllowConcurrentEvents
    public void onValidateStatement(ValidateEvent event) throws InkException {
        ISimpleStatementMetaValidator simpleStatementMetaValidator = SimpleStatementValidatorFactory.getInstance(event.getAuth(), event.getStatementGroupTypeEnum(), event.getSimpleMetaStoreProviderImp());
        boolean isValidate = simpleStatementMetaValidator.isValidate(event.getStatement());
        event.setValidate(isValidate);
    }
}
