package ru.javapj.thelife.thelife.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author alex
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game {
    
    private UUID id;
    private int width;
    private int height;
    private List<Cell> cells;
    
    public List<Cell> move() throws CloneNotSupportedException {
        List<Cell> next = new ArrayList<>();
        
        for(Cell cell : cells) {
            Cell nextCell = cell.clone();
            int act = getActiveNeighboursCount(cell);
            if(cell.isValue()) {
                if(act > 1 && act < 4) {
                    nextCell.setValue(true);
                } else {
                    nextCell.setValue(false);
                }
            } else {
                if(act == 3) {
                    nextCell.setValue(true);
                }
            }
            next.add(nextCell);
        }
        cells = next;
        return cells;
    }
    
    private int getActiveNeighboursCount(Cell c) {
        int count = 0;
        for(Cell cell : cells) {
            if((( cell.getX() <= c.getX()+1 &&
                  cell.getX() >= c.getX()-1) ||
                ((c.getX() == 0 && cell.getX() == width-1 ) || (c.getX() == width-1 && cell.getX() == 0) )) &&
               (( cell.getY() <= c.getY()+1 &&
                  cell.getY() >= c.getY()-1) ||
                ((c.getY() == 0 && cell.getY() == height-1) || (c.getY() == height-1 && cell.getY() == 0) )) &&
               cell.isValue()
            ) {
                count++;
            }
        }
        if(c.isValue()) count--;
        return count;
    }
}
