package com.fuze.coreuc.schiaparelli.datastores;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.MessageFormat;

import org.apache.http.client.utils.URIBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fuze.coreuc.schiaparelli.models.QueueStatus;
import com.fuze.coreuc.schiaparelli.models.QueueSummary;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SynapseStore {

	private final String scheme = "https";
	private final String host = "synapse.qtw.thinkingphones.com";
	private final String username = "dkus.super";
	private final String password = "Think123";
	private final String summaryPath = "/tpn-webapi-broker/services/queues/%s/summary";
	private final String statusPath = "/tpn-webapi-broker/services/queues/%s/status";

	private final OkHttpClient client;
	private final ObjectMapper mapper;
	private final URIBuilder uriBuilder;

	public SynapseStore(OkHttpClient client) {
		this.client = client;
		this.mapper = new ObjectMapper();
		this.uriBuilder = new URIBuilder();
	}

	private URI createPath(final String path) throws URISyntaxException {
		return uriBuilder.setScheme(scheme).setHost(host).setPath(path).build();
	}

	private URL createSummaryPath(final String queueName) throws URISyntaxException, MalformedURLException {
		String path = String.format(summaryPath, queueName);
		return createPath(path).toURL();
	}

	private URL createStatusPath(final String queueName) throws URISyntaxException, MalformedURLException {
		String path = String.format(statusPath, queueName);
		return createPath(path).toURL();
	}

	public QueueSummary getSummary (String queueName) {
		try {
			URL url = createSummaryPath(queueName);
			String responseBody = query(url);
			return mapper.readValue(responseBody, QueueSummary.class);
		}
		catch (URISyntaxException e) {
		}
		catch (MalformedURLException e) {
		}
		catch (IOException e) {
		}
		return null;
	}

	public QueueStatus getStatus (String queueName) {
		try {
			URL url = createStatusPath(queueName);
			String responseBody = query(url);
			return mapper.readValue(responseBody, QueueStatus.class);
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
				.header("Accept", "application/json")
				.header("password", password)
				.header("username", username)
				.build();
		return request;
	}

	private String query(URL url) throws IOException {
		Request request = buildRequest(url);
		Response response = client.newCall(request).execute();
		return response.body().string();
	}
}
