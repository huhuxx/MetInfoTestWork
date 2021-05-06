package com.sport.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sport.base.BaseTest;
import com.sport.pages.NotesListPage;

public class NodeTest extends BaseTest{
	NotesListPage notesListPage;
	@BeforeClass
	public void initPage() {
		notesListPage=new NotesListPage(driver);
	}
	@Test
	public void test_add() throws InterruptedException {
		notesListPage.add_note("��һ��");
	}
	@Test
	public void test_delete() throws InterruptedException {
		notesListPage.delete_note();
	}
	@Test
	public void testCopy() throws InterruptedException {
		notesListPage.copy_note();	
	}
	@Test
	public void upDate()throws InterruptedException {
		notesListPage.update_note("���±���");
	}
}
