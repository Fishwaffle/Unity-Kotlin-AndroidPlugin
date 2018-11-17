using UnityEngine;
using AndroidPlugin;

public class SampleDialogFragment : MonoBehaviour
{
    public void onClick()
    {
        DialogFragment.showDialogFragment(title:"質問",message: "たい焼きはつぶ餡派?",
            positiveMessage:"YES",
            positiveCallbackName:nameof(onDialogPositiveButton),
            negativeMessage:"NO",
            negativeCallbackName:nameof(onDialogNegativeButton),
            gameObjectName:gameObject.name);
    }
    public void onDialogPositiveButton()
    {
        Toast.show("(*´ω｀*)", 0);
    }
    public void onDialogNegativeButton()
    {
        Toast.show("(´・ω・｀)", 0);
    }
}
