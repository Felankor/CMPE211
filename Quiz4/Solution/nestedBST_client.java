package Quiz4;

/**
 *
 * @author uzaycetin
 */
public class nestedBST_client {
    public static String[] movies = {
            "Star Wars", "The Dark Knight", "Gladiator",
            "Up", "Wall-E", "Superman",
            "Titanic", "Amelie", "Casablanca"};
        
     public static double similarity(BST<String, BST<String, Double> > data, String person1, String person2){
        double distance = 0.0;
        for (int i = 0; i < movies.length; i++) {
            double score1 = data.get(person1).get(movies[i]);
            double score2 = data.get(person2).get(movies[i]);
            distance += Math.pow((score1 - score2), 2);
        }
        
        return 1.0/ (1.0 + distance);
     }   
     public static void main(String[] args) {
        //////////////////////////////////////////////////////////////////////
        // critics1
        BST<String, Double> Ahmet;
        Ahmet = new BST<>();
        
        Double[] critics = {
            5.0, 5.0, 5.0,
            3.0, 3.0, 3.0,
            1.0, 1.0, 1.0
        };
        
        for (int i = 0; i < movies.length; i++) {
            Ahmet.put(movies[i], critics[i]);
        }
        
        System.out.print("Ahmet :");Ahmet.show();
        
        //////////////////////////////////////////////////////////////////////
        // critics2
        BST<String, Double> Berk;
        Berk = new BST<>();
        
        Double[] critics2 = {
            3.0, 3.0, 3.0,
            5.0, 5.0, 5.0,
            1.0, 1.0, 1.0
        };
        
        for (int i = 0; i < movies.length; i++) {
            Berk.put(movies[i], critics2[i]);
        }
        
        System.out.print("Berk :");Berk.show();
        
        
        //////////////////////////////////////////////////////////////////////
        // critics3
        BST<String, Double> Selin;
        Selin = new BST<>();
        
        Double[] critics3 = {
            1.0, 1.0, 1.0,
            3.0, 3.0, 3.0,
            5.0, 5.0, 5.0
        };
        
        for (int i = 0; i < movies.length; i++) {
            Selin.put(movies[i], critics3[i]);
        }
        
        System.out.print("Selin :");Selin.show();    
        
        
        
        
        //////////////////////////////////////////////////////////////////////
        // nested symbol table
        BST<String, BST<String, Double> > data;
        data = new BST<>(); 
        
        data.put("Ahmet", Ahmet);
        data.put("Berk", Berk);
        data.put("Selin", Selin);
        System.out.print("Data :");data.show();

        
        System.out.println("Ahmets critic on movie Star Wars: " + data.get("Ahmet").get("Star Wars"));
        
        
        
        // Similarity
        String person1 = "Ahmet", person2 = "Selin";
        System.out.println("Similarity between " + person1 + 
                " and " + person2 + " is " + similarity(data,person1, person2));

        person1 = "Ahmet"; person2 = "Berk";
        System.out.println("Similarity between " + person1 + 
                " and " + person2 + " is " + similarity(data,person1, person2));
        
        person1 = "Selin"; person2 = "Berk";
        System.out.println("Similarity between " + person1 + 
                " and " + person2 + " is " + similarity(data,person1, person2));
    }
}
