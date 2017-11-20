package be.vdab.oak3evaluationform.Mapper;

import be.vdab.oak3evaluationform.Model.EnumCategory;
import be.vdab.oak3evaluationform.Model.EnumScore;

public class EnumMapper {


    public static EnumScore mapToScore(int score){

        for(EnumScore s : EnumScore.values()){
            if(s.ordinal() == score){
                return s;
            }
        }
        throw new RuntimeException("Score not found!");
    }

    public static EnumCategory mapToCategory(int category){

        for(EnumCategory c : EnumCategory.values()){
            if(c.ordinal() == category){
                return c;
            }
        }
        throw new RuntimeException("Category not found!");
    }
}
