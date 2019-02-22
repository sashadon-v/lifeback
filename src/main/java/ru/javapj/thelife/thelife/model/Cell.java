package ru.javapj.thelife.thelife.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Cell implements Cloneable {
    
    private int id;    
    @JsonIgnore
    private UUID gameId;
    private int x;
    private int y;
    private boolean value;
    
    @Override
    public Cell clone() throws CloneNotSupportedException {
        return (Cell) super.clone();
    }
}
