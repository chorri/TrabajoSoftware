using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ScreenNavManager : MonoBehaviour
{
    public List<Transform> screens;
    public Transform hamburger;

    public int currentScreen = 0;

    // Start is called before the first frame update
    void Start()
    {

    }

    // Update is called once per frame
    void Update()
    {

    }

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
        hamburger.GetComponent<Animator>().SetBool("On",state);
    }
}
