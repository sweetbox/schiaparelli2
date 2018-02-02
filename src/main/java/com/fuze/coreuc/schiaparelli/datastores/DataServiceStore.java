package com.fuze.coreuc.schiaparelli.datastores;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.http.client.utils.URIBuilder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fuze.coreuc.schiaparelli.mappers.MapperUser;
import com.fuze.coreuc.schiaparelli.models.User;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DataServiceStore {

	private final String scheme = "http";
	private final String host = "ucapi.qtw.tpn.thinkingphones.net";
	private final String peerPath = "/tpn-coreuc-data-service/peer/%s";

	private final OkHttpClient client;
	private final ObjectMapper mapper;
	private final URIBuilder uriBuilder;

	public DataServiceStore(OkHttpClient client) {
		this.client = client;
		this.mapper = new ObjectMapper();
		this.uriBuilder = new URIBuilder();
	}

	private URI createPath(final String path) throws URISyntaxException {
		return uriBuilder.setScheme(scheme).setHost(host).setPath(path).addParameter("expanded", "true").build();
	}

	private URL createPeerPath(final String peerName) throws URISyntaxException, MalformedURLException {
		String path = String.format(peerPath, peerName);
		return createPath(path).toURL();
	}

	public User getUser (String queueName) {
		try {
			URL url = createPeerPath(queueName);
			String responseBody = query(url);
			JsonNode jsonNode = mapper.readTree(responseBody);
			return mapper.treeToValue(jsonNode.get("user"), User.class);
		}
		catch (URISyntaxException e) {
		}
		catch (MalformedURLException e) {
		}
		catch (IOException e) {
		}
		return null;
	}

	private Request buildRequest (URL url) {
		Request request = new Request.Builder()
				.url(url)
				.build();
		return request;
	}

	private String query(URL url) throws IOException {
		Request request = buildRequest(url);
		Response response = client.newCall(request).execute();
		return response.body().string();
	}
}
