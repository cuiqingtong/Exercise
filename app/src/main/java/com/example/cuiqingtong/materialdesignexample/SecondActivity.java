package com.example.cuiqingtong.materialdesignexample;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by cuiqingtong on 2016/8/8.
 */
public class SecondActivity extends AppCompatActivity{
	DrawerLayout drawerLayout;
	ActionBarDrawerToggle drawerToggle;
	private FloatingActionButton fabBtn;
	private Toolbar toolbar;
	private TabLayout tabLayout;
	private CollapsingToolbarLayout collapsingToolbarLayout;
	private NavigationView navigation;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		initInstances();
	}
	private void initInstances() {
		toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
		drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close);
		drawerLayout.setDrawerListener(drawerToggle);

		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		final CoordinatorLayout rootLayout = (CoordinatorLayout) findViewById(R.id.rootLayout);
		fabBtn = (FloatingActionButton) findViewById(R.id.fabBtn);
		fabBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Snackbar.make(rootLayout, "Hello. I am Snackbar!", Snackbar.LENGTH_SHORT)
						.setAction("Undo", new View.OnClickListener() {
							@Override
							public void onClick(View v) {
							}
						})
						.show();
			}
		});

		tabLayout = (TabLayout) findViewById(R.id.tabLayout);
		tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
		tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
		tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));
		collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarLayout);
		collapsingToolbarLayout.setTitle("cuiqingtong");

		navigation = (NavigationView) findViewById(R.id.navigation);
		navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
			@Override
			public boolean onNavigationItemSelected(MenuItem menuItem) {
				int id = menuItem.getItemId();
				Snackbar.make(rootLayout, "Hello. I am " + id, Snackbar.LENGTH_SHORT)
						.setAction("Undo", new View.OnClickListener() {
							@Override
							public void onClick(View v) {
							}
						})
						.show();
				return false;
			}
		});
	}

	@Override
	public void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		drawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		drawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (drawerToggle.onOptionsItemSelected(item))
			return true;

		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
