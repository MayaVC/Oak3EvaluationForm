package be.vdab.oak3evaluationform.Mapper;

import be.vdab.oak3evaluationform.Model.Category;
import be.vdab.oak3evaluationform.Model.Score;

public class EnumMapper {


    public static Score mapToScore(int score){

        for(Score s : Score.values()){
            if(s.ordinal() == score){
                return s;
            }
        }
        throw new RuntimeException("Score not found!");
    }

    public static Category mapToCategory(int category){

        for(Category c : Category.values()){
            if(c.ordinal() == category){
                return c;
            }
        }
        throw new RuntimeException("Category not found!");
    }
}
