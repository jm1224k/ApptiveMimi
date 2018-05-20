package mimiz.week6;

public class ListViewItem extends SQLiteFriendsData{
    int image;
    String name, message;

    public ListViewItem(int image, String name, String message) {
        this.image = image;
        this.name = name;
        this.message = message;
    }

    public int getImage(){return image;}
    public String getName(){return name;}
    public String getMessage( ){return message;}

}
