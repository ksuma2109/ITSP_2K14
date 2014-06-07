package com.example.mycalci;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	int result;
	boolean received;
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
	
	public void add(View view)
	{
		EditText num1 = (EditText) findViewById(R.id.editText1);
		String num1s = num1.getText().toString();
		
		EditText num2 = (EditText) findViewById(R.id.editText2);
		String num2s = num2.getText().toString();
		if(TextUtils.isEmpty(num2s) || TextUtils.isEmpty(num1s))
		{
			TextView res = (TextView) findViewById(R.id.textView1);
			res.setText("hey where is other number?");
			return;
		}
		int a = Integer.parseInt(num1s);
		int b = Integer.parseInt(num2s);
		
		int result = a+b;
		
		TextView res = (TextView) findViewById(R.id.textView1);
		res.setText(Integer.toString(result));

	}
	
	public void subtract(View view)
	{
		EditText num1 = (EditText) findViewById(R.id.editText1);
		String num1s = num1.getText().toString();
		
		EditText num2 = (EditText) findViewById(R.id.editText2);
		String num2s = num2.getText().toString();
		if(TextUtils.isEmpty(num2s) || TextUtils.isEmpty(num1s))
		{
			TextView res = (TextView) findViewById(R.id.textView1);
			res.setText("hey where  other number?");
			return;
		}
		else{
		int a = Integer.parseInt(num1s);
		int b = Integer.parseInt(num2s);
		
		int result = a-b;
		
		TextView res = (TextView) findViewById(R.id.textView1);
		res.setText(Integer.toString(result));
		}
		Log.d("test","subtract");
	}
	
	public void multiply (View view)
	{
		EditText num1 = (EditText) findViewById(R.id.editText1);
		String num1s = num1.getText().toString();
		 
		EditText num2 = (EditText) findViewById(R.id.editText2);
		String num2s = num2.getText().toString();
		if(TextUtils.isEmpty(num2s) || TextUtils.isEmpty(num1s))
		{
			TextView res = (TextView) findViewById(R.id.textView1);
			res.setText("hey where is other number?");
			return;
		}
		int a = Integer.parseInt(num1s);
		int b = Integer.parseInt(num2s);
		int result = a*b;
		
		TextView res = (TextView) findViewById(R.id.textView1);
		res.setText(Integer.toString(result));
	}
	
	public void divide(View view)
	{
		EditText num1 = (EditText) findViewById(R.id.editText1);
		String num1s = num1.getText().toString();
		
		EditText num2 = (EditText) findViewById(R.id.editText2);
		String num2s = num2.getText().toString();
		if(TextUtils.isEmpty(num2s) || TextUtils.isEmpty(num1s))
		{
			TextView res = (TextView) findViewById(R.id.textView1);
			res.setText("hey where is other number?");
			return;
		}
		int a = Integer.parseInt(num1s);
		int b = Integer.parseInt(num2s);
		double p = b*1.0;
		double result = a/p;
		
		TextView res = (TextView) findViewById(R.id.textView1);
		res.setText(Double.toString(result));
	}

}
