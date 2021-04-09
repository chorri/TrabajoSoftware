using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class JokeManager : MonoBehaviour
{
    public Text jokeTest;
    
    public void GenJoke()
    {
        jokeTest.text = APIHelper.GetNewJoke().value;
    }
}
