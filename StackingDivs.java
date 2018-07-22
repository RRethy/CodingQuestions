import java.util.ArrayList;
import java.lang.Integer;

public class StackingDivs {

  public static void main(String[] args) {
    Col c11 = new Col(5, 1);
    Col c12 = new Col(2, 1);
    Col c13 = new Col(1, 1);
    Col c21 = new Col(1, 1);
    Col c22 = new Col(3, 1);
    Col c31 = new Col(2, 2);
    Col c32 = new Col(2, 2);
    Row r1 = new Row();
    r1.cols.add(c11);
    r1.cols.add(c12);
    r1.cols.add(c13);
    Row r2 = new Row();
    r2.cols.add(c21);
    r2.cols.add(c22);
    Row r3 = new Row();
    r3.cols.add(c31);
    r3.cols.add(c32);
    Table t = new Table();
    t.rows.add(r1);
    t.rows.add(r2);
    t.rows.add(r3);
    int length = findTableLength(t);
    System.out.println(String.valueOf(length));
  }

  private static int findTableLength(Table t) {
    ArrayList<Integer> stacks = new ArrayList<>();
    for (int ri = 0; ri < t.rows.size(); ri++) {
      for (int ci = 0; ci < t.rows.get(ri).cols.size(); ci++) {
        int colh = t.rows.get(ri).cols.get(ci).height;
        int colw = t.rows.get(ri).cols.get(ci).width;
        for (int i = 0; i < stacks.size(); i++) {
          if (stacks.get(i) <= ri + 1) {
            stacks.set(i, ri + colh);
            colw--;
          }
          if (colw == 0) {
            break;
          }
        }
        while (colw > 0) {
          stacks.add(ri + colh);
          colw--;
        }
      }
    }
    return stacks.size();
  }

  public static class Table {
    ArrayList<Row> rows = new ArrayList<>();
  }

  public static class Row {
    ArrayList<Col> cols = new ArrayList<>();
  }

  public static class Col {
    int height;
    int width;
    public Col(int height, int width) {
      this.height = height;
      this.width = width;
    }
  }
}
