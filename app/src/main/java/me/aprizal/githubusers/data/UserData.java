package me.aprizal.githubusers.data;

import java.util.ArrayList;
import java.util.List;

import me.aprizal.githubusers.R;
import me.aprizal.githubusers.model.UserModel;

public class UserData {
    public static List<UserModel> userModelList(){
        ArrayList<UserModel> userModels = new ArrayList<>();
        userModels.add(new UserModel(
                R.raw.jeffrafter,
                "Jeff Rafter",
                "jeffrafter",
                "2.8k",
                "275",
                "GitHub",
                "Redlands, California",
                "282"
                ));
        userModels.add(new UserModel(
                R.raw.poteto,
                "Lauren Tan",
                "poteto",
                "2.8k",
                "7",
                "@facebook",
                "nyc",
                "142"
        ));
        userModels.add(new UserModel(
                R.raw.dynamicwebpaige,
                "Paige Bailey",
                "dynamicwebpaige",
                "1.5k",
                "136",
                "@microsoft",
                "Seattle, WA",
                "107"
        ));
        userModels.add(new UserModel(
                R.raw.mxschmitt,
                "Max Schmitt",
                "mxschmitt",
                "656",
                "25",
                "@microsoft",
                "Germany, Berlin",
                "92"
        ));
        userModels.add(new UserModel(
                R.raw.jcinis,
                "Jessey White-Cinis",
                "jcinis",
                "69",
                "71",
                "Mind The Algorithm",
                "Cyberspace",
                "13"
        ));
        userModels.add(new UserModel(
                R.raw.rsrahul1000,
                "Rahul S Sharma",
                "rsrahul1000",
                "10",
                "7",
                "DBCE",
                "Vasco, Goa, India",
                "54"
        ));
        userModels.add(new UserModel(
                R.raw.dyutidave,
                "Dyuti dave",
                "dyutidave",
                "6",
                "16",
                "Stevens Institute of Technology",
                "New Jersey",
                "11"
        ));
        userModels.add(new UserModel(
                R.raw.jules2689,
                "Julian Nadeau",
                "jules2689",
                "176",
                "16",
                "@github",
                "Toronto, On, Canada",
                "93"
        ));
        userModels.add(new UserModel(
                R.raw.thebradbain,
                "Bradley Bain",
                "thebradbain",
                "107",
                "16",
                "Pomona College",
                "Los Angeles, CA | Dallas, TX",
                "17"
        ));
        userModels.add(new UserModel(
                R.raw.dilipsuthar97,
                "Dilip Suthar",
                "dilipsuthar97",
                "43",
                "21",
                "Individual",
                "India",
                "57"
        ));
        return userModels;
    }
}
