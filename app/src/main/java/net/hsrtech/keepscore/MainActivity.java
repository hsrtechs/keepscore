package net.hsrtech.keepscore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity
{

    public Team teamOne;
    public Team teamTwo;

    public Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        this.teamOne = new Team();
        this.teamTwo = new Team();

        setContentView(R.layout.activity_main);
    }


    public void addScore(View view)
    {
        Team team = this.getActiveTeam();

        switch (view.getId())
        {
            case R.id.runOne    : { team.addRuns(1); break; }
            case R.id.runTwo    : { team.addRuns(2); break; }
            case R.id.runThree  : { team.addRuns(3); break; }
            case R.id.runFour   : { team.addRuns(4); break; }
            case R.id.runFive   : { team.addRuns(5); break; }
            case R.id.runSix    : { team.addRuns(6); break; }

            case R.id.boundryFour   : { team.addFour(); break; }
            case R.id.boundrySix    : { team.addSix();  break; }

            case R.id.biesOne   : { this.addBies(1); break; }
            case R.id.biesTwo   : { this.addBies(2); break; }
            case R.id.biesThree : { this.addBies(3); break; }
            case R.id.biesFour  : { this.addBies(4); break; }
            case R.id.biesFive  : { this.addBies(5); break; }
            case R.id.biesSix   : { this.addBies(6); break; }

            default : { toast("Failed"); break; }
        }

        if(this.toast != null)
        {
            this.toast.cancel();
        }
        this.runsToast(team.score());
    }

    public Team getActiveTeam()
    {
        ToggleButton teamToggle = (ToggleButton) findViewById(R.id.teamToggle);

        return teamToggle.isChecked() ? this.teamOne : this.teamTwo;
    }

    public Team addBies(int score)
    {
        ToggleButton biesToggle = (ToggleButton) findViewById(R.id.biesToggle);
        Boolean bies = biesToggle.isChecked();

        Team team = this.getActiveTeam();

        if(bies)
        {
            return team.addBies(score);
        } else
        {
            return team.addLegBies(1);
        }
    }


    public Toast runsToast(int score)
    {
        return this.toast("Runs: " + score);
    }

    public Toast toast(String toast)
    {
        this.toast = Toast.makeText(getApplicationContext(), toast, Toast.LENGTH_SHORT);
        this.toast.show();

        return this.toast;
    }
}
