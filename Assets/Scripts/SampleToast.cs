using UnityEngine;
using AndroidPlugin;
public class SampleToast : MonoBehaviour
{
    public void onClick()
    {
        Toast.show("たい焼き食べたい", 0);
    }
}
