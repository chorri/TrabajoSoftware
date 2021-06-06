using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class NoteButton : MonoBehaviour
{
    public bool holding = false;
    public float timeToHold = 1;
    float holdStart;
    public Vector3 holdingSize;

    [Header("References")]
    public Text noteTitle;
    public Image notePriority;
    public RectTransform rectTransform;
    public Animator noteButtonAnim;

    private void Update()
    {
        if (NoteManager.instance.currentBehaviour == NoteManager.NotesBehaviour.delete)
        {
            noteButtonAnim.SetBool("Delete", true);
        } else
        {
            noteButtonAnim.SetBool("Delete", false);
        }
    }

    private void FixedUpdate()
    {
        if (holding && Time.time - holdStart >= timeToHold)
        {
            Debug.Log("Holding");
            NoteManager.instance.ChangeBehaviour(1);
            NoteManager.instance.HoldNote(true);
        }
    }

    public void SetHold(bool state)
    {
        holding = state;
        holdStart = Time.time;
    }

    private void OnMouseDown()
    {
        holding = true;
        holdStart = Time.time;
        rectTransform.localScale = holdingSize;
    }

    private void OnMouseUp()
    {
        holding = false;
        rectTransform.localScale = Vector3.one;
    }

    private void OnMouseExit()
    {
        holding = false;
        rectTransform.localScale = Vector3.one;
    }
}
