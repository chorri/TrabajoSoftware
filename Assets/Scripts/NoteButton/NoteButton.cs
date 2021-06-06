using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class NoteButton : MonoBehaviour
{
    public bool holding = false;
    public bool prompEdit = false;
    public float timeToHold = 1;
    float holdStart;
    public Vector3 holdingSize;
    float holdOffset = 50f;
    Vector3 holdStartPos;

    [Header("References")]
    public Text noteTitle;
    public Image notePriority;
    public RectTransform rectTransform;
    public Animator noteButtonAnim;

    private void Update()
    {
        switch (NoteManager.instance.currentBehaviour)
        {
            case NoteManager.NotesBehaviour.normal:
                noteButtonAnim.SetBool("Delete", false);
                transform.GetComponent<Collider2D>().enabled = true;
                break;
            case NoteManager.NotesBehaviour.delete:
                noteButtonAnim.SetBool("Delete", true);
                prompEdit = false;
                break;
            case NoteManager.NotesBehaviour.busy:
                noteButtonAnim.SetBool("Delete", false);
                prompEdit = false;
                transform.GetComponent<Collider2D>().enabled = false;
                break;
            default:
                break;
        }
        if (NoteManager.instance.currentBehaviour == NoteManager.NotesBehaviour.delete)
        {
            noteButtonAnim.SetBool("Delete", true);
            prompEdit = false;
        } else
        {
            noteButtonAnim.SetBool("Delete", false);
        }
    }

    private void FixedUpdate()
    {
        if (Vector3.Distance(Input.mousePosition,holdStartPos) > holdOffset)
        {
            holding = false;
            prompEdit = false;
            rectTransform.localScale = Vector3.one;
        }

        if (holding && Time.time - holdStart >= timeToHold)
        {
            NoteManager.instance.ChangeBehaviour(1);
            NoteManager.instance.HoldNote(true);
            holding = false;
            prompEdit = false;
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
        prompEdit = true;
        holdStart = Time.time;
        rectTransform.localScale = holdingSize;

        holdStartPos = Input.mousePosition;
    }

    private void OnMouseUp()
    {
        holding = false;
        rectTransform.localScale = Vector3.one;

        if (prompEdit)
        {
            NoteManager.instance.EditNotePromp(true);
            NoteManager.instance.ChangeBehaviour(2);//Edit Behaviour
        }
    }

    private void OnMouseExit()
    {
        
    }
}
