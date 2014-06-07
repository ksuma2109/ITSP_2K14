package com.example.hi;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	TextView res;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}
	
	public void go(View view)
	{
		EditText url = (EditText) findViewById(R.id.editText1);
		String adrs = url.getText().toString();
		res = (TextView) findViewById(R.id.textView1);
		Log.d("test","Let's try");
		res.setText("URL Taking");
		Log.d("test","setText has no probs");
		ConnectivityManager conMgr = (ConnectivityManager) 
	            getSystemService(Context.CONNECTIVITY_SERVICE);
		// to get the network status.
		NetworkInfo info = (NetworkInfo) conMgr.getActiveNetworkInfo();
		
		// if info is not null and isConnected ()
		if(info != null && info.isConnected())
		{
			Log.d("yo","Network connection Available!!");
			res.setText("Seems like you have network connection.");
		    new Downloader().execute(adrs);
			
		}
		else 
		{
			res.setText("Hey u know what an internet connection is required to download xml.");
		}
		
		
		
	}
	
	private class Downloader extends AsyncTask<String, Void, String>
	{
		@Override
		protected String doInBackground(String... ars)
		{
			Log.d("test","entered to download string");
	
			res.setText("fetching data from"+ars[0]);
			try
			{
				return downloadUrl(ars[0]);
			}
			catch(Exception e)
			{
				return "What am i supposed to do with invalid URL??";
			}
			
		}
		
		protected void onPostExecute(String result)
		{
			Log.d("test","Completed Download.");
			res.setText(result);
		}
		
	}
		private String downloadUrl(String myurl) throws IOException {
			res.setText("Callng direct download");
			Log.d("test","trying to download from url");
		    InputStream is = null;
		    // Only display the first 500 characters of the retrieved
		    // web page content.
		    int len = 500;
		        
		    try {
		        URL url = new URL(myurl);
		        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		        conn.setReadTimeout(10000 /* milliseconds */);
		        conn.setConnectTimeout(15000 /* milliseconds */);
		        conn.setRequestMethod("GET");
		        conn.setDoInput(true);
		        // Starts the query
		        conn.connect();
		        int response = conn.getResponseCode();
		        Log.d("debug", "The response is: " + response);
		        is = conn.getInputStream();

		        // Convert the InputStream into a string
		        String contentAsString = readIt(is, len);
		        return contentAsString;
		        
		    // Makes sure that the InputStream is closed after the app is
		    // finished using it.
		    } finally {
		        if (is != null) {
		            is.close();
		        } 
		    }
		}
		public String readIt(InputStream stream, int len) throws IOException, UnsupportedEncodingException {
		    Reader reader = null;
		    reader = new InputStreamReader(stream, "UTF-8");        
		    char[] buffer = new char[len];
		    reader.read(buffer);
		    return new String(buffer);
		}
	}


