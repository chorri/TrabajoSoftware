using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ScreenNavManager : MonoBehaviour
{
    public List<Transform> screens;

    public int currentScreen = 0;

    [Header("Animators")]
    public Animator hamburger;
    public Animator note;

    public void ChangeScreen(int newScreen)
    {
        //Transition
        screens[newScreen].gameObject.SetActive(true);
        screens[currentScreen].gameObject.SetActive(false);
        //Change
        currentScreen = newScreen;
    }

    public void EnableHamburger(bool state)
    {
        hamburger.SetBool("HamState", state);
    }

    public void AddNote(bool state)
    {
        note.SetBool("AddNote",state);
    }

    public void Test()
    {
        Debug.Log("TEXTO TEST");
    }
}
