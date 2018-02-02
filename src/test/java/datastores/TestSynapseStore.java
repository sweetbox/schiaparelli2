package datastores;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import com.fuze.coreuc.schiaparelli.datastores.SynapseStore;
import com.fuze.coreuc.schiaparelli.models.QueueStatus;
import com.fuze.coreuc.schiaparelli.models.QueueSummary;

import okhttp3.OkHttpClient;

public class TestSynapseStore {

	private SynapseStore synapseStore;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		synapseStore = new SynapseStore(new OkHttpClient());
	}

	@Test
	public void testQueryStatus() {
		QueueStatus queueStatus = synapseStore.getStatus("ucapps1-queue1");
		Assert.assertNotNull(queueStatus);
	}

	@Test
	public void testQuerySummary() {
		QueueSummary queueSummary = synapseStore.getSummary("ucapps1-queue1");
		Assert.assertNotNull(queueSummary);
	}

}
