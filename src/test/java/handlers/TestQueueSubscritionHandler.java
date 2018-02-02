package handlers;

import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

import com.fuze.coreuc.schiaparelli.exceptions.InternalErrorException;
import com.fuze.coreuc.schiaparelli.exceptions.InvalidRequestException;
import com.fuze.coreuc.schiaparelli.handlers.QueueSubscriptionHandler;

public class TestQueueSubscritionHandler {

	@Mock
	Context context;

	@Mock
	ClientContext clientContext;

	@Mock
	CognitoIdentity cognitoIdentity;

	@Mock
	LambdaLogger lambdaLogger;

	QueueSubscriptionHandler queueSubscriptionHandler = new QueueSubscriptionHandler();

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		when(context.getClientContext()).thenReturn(clientContext);
		when(context.getIdentity()).thenReturn(cognitoIdentity);
		when(context.getLogger()).thenReturn(lambdaLogger);
	}

	@Test
	public void testLambda() throws InvalidRequestException, InternalErrorException {
		InputStream stubInputStream = IOUtils.toInputStream(
				"{\"queueName\":\"ucapps1-queue1\","
				+ "\"tenantId\":\"ucapps1\","
				+ "\"userId\":\"apruner1.ucapps\","
				+ "\"queueInterface\":\"UCAPPS1-x1823\","
				+ "\"timestamp\":1517432123450,"
				+ "\"id\":1212,"
				+ "\"state\":\"UNAVAILABLE\"}"
				, Charset.defaultCharset());
		OutputStream stubOutputStream = new ByteArrayOutputStream();
		//QueueSubscriptionHandler.lambdaHandler(stubInputStream, stubOutputStream, context);
	}


}
