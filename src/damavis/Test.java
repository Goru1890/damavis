package damavis;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("Acceptance tests\n");
		SnakeGame snakeGame = new SnakeGame();
		
		System.out.println("Test 1:\n  - board:[4:3]\n  - snake: [[2,2], [3,2], [3,1], [3,0], [2,0], [1,0], [0,0]]\n  - depth: 3\nResult: " + Integer.toString(test1()) + "\n\n");
		System.out.println("Test 2:\n  - board:[2:3]\n  - snake: [[0,2], [0,1], [0,0], [1,0], [1,1], [1,2]]\n  - depth: 10\nResult: " + Integer.toString(test2()) + "\n\n");
		System.out.println("Test 3:\n  - board:[10:10]\n  - snake: [[5,5], [5,4], [4,4], [4,5]]\n  - depth: 4\nResult: " + Integer.toString(test3()) + "\n\n");
		

	}
	
	public static Integer test1() {

		Integer[] board = { 4, 3 };
		Integer[][] snake = { { 2, 2 }, { 3, 2 }, { 3, 1 }, { 3, 0 }, { 2, 0 }, { 1, 0 }, { 0, 0 } };
		SnakeGame snakeGame = new SnakeGame();
		return snakeGame.path(board, snake, 3);

	}

	public static Integer test2() {

		Integer[] board = { 2, 3 };
		Integer[][] snake = { { 0, 2 }, { 0, 1 }, { 0, 0 }, { 1, 0 }, { 1, 1 }, { 1, 2 } };
		SnakeGame snakeGame = new SnakeGame();
		return snakeGame.path(board, snake, 10);

	}

	public static Integer test3() {

		Integer[] board = { 10, 10 };
		Integer[][] snake = { { 5, 5 }, { 5, 4 }, { 4, 4 }, { 4, 5 } };
		SnakeGame snakeGame = new SnakeGame();
		return snakeGame.path(board, snake, 4);

	}

}
