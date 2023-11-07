/**
 * Created by tomasz_taw
 * Date: 07.11.2023
 * Time: 22:10
 * Project Name: memotrGame
 * Description:
 */
package pl.taw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class GameController {

    @GetMapping("/board")
    public String displayBoard(Model model) {
        List<List<String>> board = generateBoardData();
        model.addAttribute("rows", board);

        return "board";
    }

    private static List<String> getIcons() {
        List<String> icons = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            icons.add("icon" + i + ".png");
            icons.add("icon" + i + ".png");
        }
        return icons;
    }
    private List<List<String>> generateBoardData() {
        List<List<String>> board = new ArrayList<>();
        List<String> icons = getShuffledIcons();
        Collections.shuffle(icons);
        int cellValue = 0;

        for (int row = 0; row < 4; row++) {
            List<String> rowList = new ArrayList<>();
            for (int col = 0; col < 4; col++) {
                String prefix = "/images/";
                String imagePath = prefix + icons.get(cellValue);
                rowList.add(imagePath);
                cellValue++;
            }
            board.add(rowList);
        }
        return board;
    }

    private List<String> getShuffledIcons() {
        List<String> icons = getIcons();
        Collections.shuffle(icons);
        return icons;
    }

}
