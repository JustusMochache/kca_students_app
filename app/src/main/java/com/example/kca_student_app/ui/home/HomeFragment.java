package com.example.kca_student_app.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.kca_student_app.CalendarActivity;
import com.example.kca_student_app.ProfileActivity;
import com.example.kca_student_app.R;
import com.example.kca_student_app.ui.LibraryActivity;
import com.example.kca_student_app.ui.NewsActivity;

public class HomeFragment extends Fragment implements View.OnClickListener {


    private HomeViewModel hViewModel;
    private CardView profilecardview, newscardview,socialcardview,notificationscardview,librarycardview,calendarcardview,buseventscardview,mapscardview;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        profilecardview = (CardView) view.findViewById(R.id.profileImage);
        newscardview = (CardView) view.findViewById(R.id.newsView);
        socialcardview = (CardView) view.findViewById(R.id.socialImage);
        notificationscardview = (CardView) view.findViewById(R.id.notificationImage);
        librarycardview = (CardView) view.findViewById(R.id.libraryImage);
        calendarcardview = (CardView) view.findViewById(R.id.calendarImage);
        buseventscardview = (CardView) view.findViewById(R.id.busEventsImage);
        mapscardview = (CardView) view.findViewById(R.id.mapsImage);

        profilecardview.setOnClickListener(this);
        newscardview.setOnClickListener(this);
        socialcardview.setOnClickListener(this);
        notificationscardview.setOnClickListener(this);
        librarycardview.setOnClickListener(this);
        calendarcardview.setOnClickListener(this);
        buseventscardview.setOnClickListener(this);
        mapscardview.setOnClickListener(this);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        hViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        // TODO: Use the ViewModel
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.profileImage:

                Toast.makeText(getActivity(), "clicked profile",Toast.LENGTH_LONG).show();
                Intent profileintent = new Intent(getActivity(), ProfileActivity.class);
                startActivity(profileintent);
            break;

            case R.id.newsView:


                Toast.makeText(getActivity(), "clicked Library",Toast.LENGTH_LONG).show();
                Intent newsintent = new Intent(getActivity(), NewsActivity.class);
                startActivity(newsintent);
                Toast.makeText(getActivity(), "clicked news",Toast.LENGTH_LONG).show();

                break;

            case R.id.busEventsImage:

                Toast.makeText(getActivity(), "clicked Bus Events",Toast.LENGTH_LONG).show();

                break;

            case R.id.socialImage:

                Toast.makeText(getActivity(), "clicked Social",Toast.LENGTH_LONG).show();

                break;

            case R.id.notificationImage:

                Toast.makeText(getActivity(), "clicked Notifications",Toast.LENGTH_LONG).show();

                break;

            case R.id.libraryImage:

                Toast.makeText(getActivity(), "clicked Library",Toast.LENGTH_LONG).show();
                Intent librintent = new Intent(getActivity(), LibraryActivity.class);
                startActivity(librintent);
                break;

            case R.id.calendarImage:

                Toast.makeText(getActivity(), "clicked Calendar",Toast.LENGTH_LONG).show();
                Intent calendarintent = new Intent(getActivity(), CalendarActivity.class);
                startActivity(calendarintent);
                break;

            case R.id.mapsImage:

                Toast.makeText(getActivity(), "clicked Maps",Toast.LENGTH_LONG).show();

                break;
        }
    }
}