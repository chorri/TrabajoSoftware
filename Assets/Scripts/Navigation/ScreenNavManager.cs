using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ScreenNavManager : MonoBehaviour
{
    #region Singleton Reference
    public static ScreenNavManager instance;

    private void Start()
    {
        instance = this;
    }
    #endregion

    public List<Transform> screens;

    public int currentScreen = 0;

    [Header("Animators")]
    public Animator hamburger;
    public Animator list;

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

    public void AddList(bool state)
    {
        list.SetBool("AddNote",state);
    }

    public void HoldList(bool state)
    {
        list.SetBool("HoldNote", state);
    }
}
