package net.hsrtech.keepscore;

class Team {

    private int _score;
    private int _legBies;
    private int _bies;
    private int _fours;
    private int _six;

    private int _wickets;

    Team addLegBies(int score)
    {
        this._legBies += score;
        return this.addScore(score);
    }

    Team addBies(int score)
    {
        this._bies += score;
        return this.addScore(score);
    }

    Team addFour()
    {
        this._fours += 1;
        return this.addScore(4);
    }

    Team addSix()
    {
        this._six += 1;
        return this.addScore(6);
    }

    Team addRuns(int score)
    {
        return this.addScore(score);
    }

    private Team addScore(int score)
    {
        this._score += score;

        return this;
    }

    void out()
    {
        this._wickets += 1;
    }

    int wickets()
    {
        return this._wickets;
    }

    int score()
    {
        return this._score;
    }

    int legBies()
    {
        return this._legBies;
    }

    int bies()
    {
        return this._bies;
    }

    int fours()
    {
        return this._fours;
    }

    int six()
    {
        return this._six;
    }
}
