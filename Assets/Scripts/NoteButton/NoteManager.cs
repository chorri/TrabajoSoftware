using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class NoteManager : MonoBehaviour
{
    public enum NotesBehaviour
    {
        normal,
        delete,
        edit
    }

    [Header("References")]
    public static NoteManager instance;
    public Animator note;
    public RectTransform noteContainer;
    public GameObject noteButtonPrefab;

    [Header("Values")]
    public int noteCount;
    public NotesBehaviour currentBehaviour;

    // Start is called before the first frame update
    void Start()
    {
        instance = this;
    }

    public void EditNotePromp(bool state)
    {
        note.SetBool("AddNote", state);
    }


    public void AddNote()
    {
        Instantiate(noteButtonPrefab,noteContainer.transform);
        noteCount++;
        if (noteCount > 4)
        {
            noteContainer.sizeDelta = new Vector2(0, 45 + ((noteCount - 5) * 90));
            /*
            Left
            rectTransform.offsetMin.x;
            
            Right
            rectTransform.offsetMax.x;
            
            Top
            rectTransform.offsetMax.y;
            
            Bottom
            rectTransform.offsetMin.y;
            */
        }
    }

    public void HoldNote(bool state)
    {
        note.SetBool("HoldNote", state);
    }

    public void ChangeBehaviour(int behaviour)
    {
        currentBehaviour = (NotesBehaviour)behaviour;
    }
}
