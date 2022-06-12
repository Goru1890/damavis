package damavis;

import java.util.ArrayList;
import java.util.List;

public class SnakeGame {

	public List<String> direction;

	public SnakeGame() {

		this.direction = new ArrayList<>();
		direction.add("L");
		direction.add("R");
		direction.add("D");
		direction.add("U");

	}

	public Integer path(Integer[] board, Integer[][] snake, Integer depth) {

		int count = 0;
		List<String> ls = new ArrayList<>();

		for (int x = 0; x < board[0]; x++) {

			for (int y = 0; y < board[1]; y++) {

				Integer[] end = new Integer[] { x, y };

				count = count + possiblePaths(board, snake, ls, end, depth);

			}

		}

		return count;

	}

	public Integer possiblePaths(Integer[] board, Integer[][] snake, List<String> currentPath, Integer[] end,
			Integer depth) {

		Integer caminos = 0;

		if (end[0] == snake[0][0] && end[1] == snake[0][1] && currentPath.size() == depth) {

			return 1;

		} else {

			Integer[] lastCell = snake[0];

			for (int x = -1; x <= 1; x = x + 1) {

				for (int y = -1; y <= 1; y = y + 1) {

					if (Math.abs(x) != Math.abs(y)) {

						Integer[] neighbor = { lastCell[0] + x, lastCell[1] + y };

						Integer[][] updatedSnake = updateSnake(snake, neighbor);

						if (isValidSnake(updatedSnake, board)
								&& (currentPath.size() < depth || currentPath.isEmpty())) {

							snake = updatedSnake;

							if (x == -1 && y == 0) {

								currentPath.add(direction.get(0));

							} else if (x == 1 && y == 0) {

								currentPath.add(direction.get(1));
							}

							else if (x == 0 && y == -1) {

								currentPath.add(direction.get(3));
							}

							else if (x == 0 && y == 1) {

								currentPath.add(direction.get(2));
							}

							Integer temp = possiblePaths(board, snake, currentPath, end, depth);
							int removeIndex = 0;

							for (int i = removeIndex; i < snake.length - 1; i++) {
								snake[i] = snake[i + 1];
							}
							caminos = caminos + temp;
							currentPath.remove(currentPath.size() - 1);

						}
					}

				}

			}

		}

		return caminos;

	}

	public Integer[][] updateSnake(Integer[][] snake, Integer[] newCell) {

		Integer[][] newSnake = new Integer[snake.length][2];

		newSnake[0] = newCell;

		for (int i = 1; i <= snake.length - 1; i++) {

			newSnake[i] = snake[i - 1];

		}

		return newSnake;

	}

	public boolean isValidSnake(Integer[][] snake, Integer[] board) {

		Boolean res = true;
		Integer count;

		for (Integer[] cells : snake) {

			res = res && cells[0] < board[0] && cells[0] >= 0;
			res = res && cells[1] < board[1] && cells[1] >= 0;
		}

		for (Integer[] cells : snake) {

			count = 0;

			for (Integer[] otherCells : snake) {

				if (cells[0] == otherCells[0] && cells[1] == otherCells[1]) {

					count++;

				}

			}

			if (count == 2) {

				res = false;

			}
		}

		return res;

	}

	
}
