package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.NotesListPage;

public class NodeTest extends BaseTest{
	NotesListPage notesListPage;
	@BeforeClass
	public void initPage() {
		notesListPage=new NotesListPage(driver);
	}
	@Test
	public void test_add() throws InterruptedException {
		notesListPage.add_note("第一条");
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
		notesListPage.update_note("更新标题");
	}
}
