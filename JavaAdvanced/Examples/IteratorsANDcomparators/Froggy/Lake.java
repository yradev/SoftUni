package JavaAdvanced.Examples.IteratorsANDcomparators.Froggy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer>{
    private List<Integer> lake = new ArrayList<>();
    public Lake(List<Integer> newlake){
        lake.addAll(newlake);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new FrogMoves();
    }

    class FrogMoves implements  Iterator<Integer>{
        int index = 0;
        boolean isFinished = false;

        @Override
        public boolean hasNext() {
            return index<lake.size();
        }

        @Override
        public Integer next() {
            int CurrentIndex=index;
            index+=2;
            if(index>=lake.size()&&!isFinished){
                index=1;
                isFinished=true;
            }
            return lake.get(CurrentIndex);
        }
    }
}
