# BASIC ANDROID TUTORIALS
- Project: Bai07 [[sudo chown -R $USER: $HOME]]
- Description: 
- Trick: 

# Create a ListView Basic
    - This is ListView Basic Of Android Studio	
	<?xml version="1.0" encoding="utf-8"?>
	<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
	    android:layout_width="match_parent"
	    android:layout_height="match_parent">

	    <ListView
		android:id="@+id/lvList"
		android:layout_width="wrap_content"
		android:layout_height="wrap_content" />
	</LinearLayout>

![alt tag](https://github.com/danisluis6/Lecture/blob/master/07/1.png)

    - Code basic view result into ListView
    private ListView mLvList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_coban);
        mLvList = (ListView) findViewById(R.id.lvList);
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            stringList.add(String.format("%s%d", "Phan tu thu:", i));
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, stringList);
        mLvList.setAdapter(arrayAdapter);
    }

![alt tag](https://github.com/danisluis6/Lecture/blob/master/07/2.png)

# Customizing ListView With BaseApdater[Class to Adapter to transform data from Activity to ListView]

    - Customize GUI [Only ListView contain widgetandroid is as Button, ListView, TextView, ..]
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
	    xmlns:tools="http://schemas.android.com/tools"
	    android:layout_width="match_parent"
	    android:layout_height="match_parent"
	    android:background="#ff00ff"
	    android:orientation="vertical"
	    android:paddingBottom="@dimen/activity_vertical_margin"
	    android:paddingLeft="@dimen/activity_horizontal_margin"
	    android:paddingRight="@dimen/activity_horizontal_margin"
	    android:paddingTop="@dimen/activity_vertical_margin">

	    <LinearLayout
		android:layout_width="match_parent"
		android:layout_height="wrap_content"
		android:orientation="vertical">

		<LinearLayout
		    android:layout_width="match_parent"
		    android:layout_height="wrap_content"
		    android:orientation="horizontal"
		    android:padding="5dp">

		    <TextView
		        android:id="@+id/tvTitle"
		        android:layout_width="0dp"
		        android:layout_height="wrap_content"
		        android:layout_weight="0.3"
		        android:text="Title: "
		        android:textColor="#fff"
		        android:textStyle="bold" />

		    <EditText
		        android:id="@+id/edtTitle"
		        android:layout_width="0dp"
		        android:layout_height="wrap_content"
		        android:layout_toRightOf="@+id/tvTitle"
		        android:layout_weight="1"
		        android:background="#fff"
		        android:padding="5dp" />
		</LinearLayout>

		<LinearLayout
		    android:layout_width="match_parent"
		    android:layout_height="wrap_content"
		    android:orientation="horizontal"
		    android:padding="5dp">

		    <TextView
		        android:id="@+id/tvContent"
		        android:layout_width="0dp"
		        android:layout_height="wrap_content"
		        android:layout_weight="0.3"
		        android:text="Content: "
		        android:textColor="#fff"
		        android:textStyle="bold" />

		    <EditText
		        android:id="@+id/edtContent"
		        android:layout_width="0dp"
		        android:layout_height="wrap_content"
		        android:layout_toRightOf="@+id/tvContent"
		        android:layout_weight="1"
		        android:background="#fff"
		        android:padding="5dp" />
		</LinearLayout>


	    </LinearLayout>

	    <Button
		android:id="@+id/btnAdd"
		android:layout_width="wrap_content"
		android:layout_height="wrap_content"
		android:layout_gravity="center"
		android:layout_marginTop="5dp"
		android:background="#00cc00"
		android:text="Add"
		android:textColor="#fff" />

	    <ListView
		android:id="@+id/lvArray"
		android:layout_width="match_parent"
		android:layout_height="wrap_content"
		android:layout_marginTop="5dp"
		android:background="#fff"
		android:headerDividersEnabled="false"
		android:footerDividersEnabled="false"
		android:divider="#fcc0"
		android:dividerHeight="3dp"
		android:padding="5dp" />
	</LinearLayout>

![alt tag](https://github.com/danisluis6/Lecture/blob/master/07/3.png)

    - Note "BaseAdapter"
    - R.layout.item_listview_user => YOU CREATE A NEW FILE XML TO CONFIGURA LISTVIEW 

	<?xml version="1.0" encoding="utf-8"?>
	<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
	    android:layout_width="match_parent"
	    android:layout_height="match_parent"
	    android:background="?android:attr/activatedBackgroundIndicator"
	    android:orientation="vertical">

	    <TextView
		android:id="@+id/tvTitle"
		android:layout_width="wrap_content"
		android:layout_height="wrap_content"
		android:text="Name"
		android:textColor="#ff0000"
		android:textSize="20dp" />

	    <TextView
		android:id="@+id/tvContent"
		android:layout_width="wrap_content"
		android:layout_height="wrap_content"
		android:text="Content" />
	</LinearLayout>

    - Image to description item ListView when you customize 

![alt tag](https://github.com/danisluis6/Lecture/blob/master/07/4.png)

    - Acitivity process ListView

	package com.example.binc.buoi7.listview_custom_base;

	import android.content.DialogInterface;
	import android.os.Bundle;
	import android.support.v7.app.AlertDialog;
	import android.support.v7.app.AppCompatActivity;
	import android.view.View;
	import android.widget.AbsListView;
	import android.widget.AdapterView;
	import android.widget.Button;
	import android.widget.EditText;
	import android.widget.ListView;
	import android.widget.Toast;

	import com.example.binc.buoi7.R;
	import com.example.binc.buoi7.User;

	import java.util.ArrayList;
	import java.util.List;

	public class BaseActivity extends AppCompatActivity {

	    private CustomListAdapter mCustomListAdapter;
	    private EditText mEdTitle;
	    private EditText mEdContent;
	    private ListView mLvMain;
	    private List<User> mUsers;

	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_custom);

		mLvMain= (ListView) findViewById(R.id.lvArray);
		mEdContent = (EditText) findViewById(R.id.edtContent);
		mEdTitle = (EditText) findViewById(R.id.edtTitle);

		mUsers = new ArrayList<>();

		mUsers.add(new User("SamSung", "aaaaaaaaaaa"));
		mUsers.add(new User("SamSung1", "aaaaaaaaaaa1"));


		mCustomListAdapter = new CustomListAdapter(this, mUsers);
		mLvMain.setAdapter(mCustomListAdapter);
		//click item listview
		mLvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
		    @Override
		    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		        User user = (User) parent.getItemAtPosition(position);
		        Toast.makeText(BaseActivity.this, user.getTitle() + "--" + user.getContent(), Toast.LENGTH_LONG).show();
		    }
		});

		mLvMain.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
		    @Override
		    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
		        showAlertDialog(position);
		        return false;
		    }
		});
		mLvMain.setOnScrollListener(new AbsListView.OnScrollListener() {
		    @Override
		    public void onScrollStateChanged(AbsListView view, int scrollState) {
		        Toast.makeText(BaseActivity.this, "Scroll", Toast.LENGTH_LONG).show();
		    }

		    @Override
		    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
		        // load more
		    }
		});
		//click add
		((Button) findViewById(R.id.btnAdd)).setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        if(mEdTitle.getText().toString().equals("")||mEdContent.getText().toString().equals("")){
		            Toast.makeText(BaseActivity.this, "Please input valid data!!", Toast.LENGTH_SHORT).show();
		            return;
		        }else {
		            mUsers.add(new User(mEdTitle.getText().toString().trim(), mEdContent.getText().toString().trim()));
		            mCustomListAdapter.notifyDataSetChanged();
		        }
		    }
		});

	    }

	    private void showAlertDialog(final int position) {
		AlertDialog.Builder builder1 = new AlertDialog.Builder(BaseActivity.this);
		builder1.setTitle("Confirm Delete");
		builder1.setMessage("Do yout want delete item!!");
		builder1.setCancelable(true);

		builder1.setPositiveButton(
		        "Yes",
		        new DialogInterface.OnClickListener() {
		            public void onClick(DialogInterface dialog, int id) {
		                mUsers.remove(position);
		                mCustomListAdapter.notifyDataSetChanged();
		                dialog.cancel();
		            }
		        });

		builder1.setNegativeButton(
		        "No",
		        new DialogInterface.OnClickListener() {
		            public void onClick(DialogInterface dialog, int id) {
		                dialog.cancel();
		            }
		        });

		AlertDialog alert11 = builder1.create();
		alert11.show();
	    }
	}

![alt tag](https://github.com/danisluis6/Lecture/blob/master/07/5.png)

# Fix Error Bundle Quickly

    // Top-level build file where you can add configuration options common to all sub-projects/modules.

	buildscript {
	    repositories {
		jcenter()
	    }
	    dependencies {
		classpath 'com.android.tools.build:gradle:2.2.2'

		// NOTE: Do not place your application dependencies here; they belong
		// in the individual module build.gradle files
	    }
	}

	allprojects {
	    repositories {
		jcenter()
	    }
	}

    -- app[Gradle]

    	apply plugin: 'com.android.application'

	android {
	    compileSdkVersion 25
	    buildToolsVersion "25.0.0"
	    defaultConfig {
		applicationId "vn.udn.dut.loginfacebookapp"
		minSdkVersion 15
		targetSdkVersion 25
		versionCode 1
		versionName "1.0"
		testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
	    }
	    buildTypes {
		release {
		    minifyEnabled false
		    proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
		}
	    }
	}

	dependencies {
	    compile fileTree(dir: 'libs', include: ['*.jar'])
	    androidTestCompile('com.android.support.test.espresso:espresso-core:2.2.2', {
		exclude group: 'com.android.support', module: 'support-annotations'
	    })
	    compile 'com.android.support:appcompat-v7:25.0.0'
	    testCompile 'junit:junit:4.12'
	}



