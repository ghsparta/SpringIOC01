package week05solution;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class Calculator{
	//业务逻辑方法
	@TimeRecording
	@Transactional
	public int div(int i, int j){
		System.out.println("--------");
		return i/j;
	}
}