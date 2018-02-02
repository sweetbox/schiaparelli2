package datastores;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import com.fuze.coreuc.schiaparelli.datastores.DataServiceStore;
import com.fuze.coreuc.schiaparelli.models.QueueStatus;
import com.fuze.coreuc.schiaparelli.models.User;

import okhttp3.OkHttpClient;

public class TestDataServiceStore {

	private DataServiceStore dataServiceStore;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		dataServiceStore = new DataServiceStore(new OkHttpClient());
	}

	@Test
	public void testGetUser() {
		User user = dataServiceStore.getUser("UCAPPS1-x2600");
	}
}
