package yuku.alkitab;

import yuku.alkitab.model.*;
import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.widget.AdapterView.*;

public class EdisiActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pilih_edisi);
		
		S.siapinEdisi(getResources());
		
		final ArrayAdapter<Edisi> adapter = new ArrayAdapter<Edisi>(this, R.layout.listitem, R.id.lLabel, S.xedisi);
		
		ListView lsEdisi = (ListView) findViewById(R.id.lsEdisi);
		lsEdisi.setAdapter(adapter);
		
		lsEdisi.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Edisi edisi = adapter.getItem(position);
				
				Intent intent = new Intent();
				intent.putExtra("nama", edisi.nama);
				setResult(RESULT_OK, intent);
				
				finish();
			}
		});
	}
}
