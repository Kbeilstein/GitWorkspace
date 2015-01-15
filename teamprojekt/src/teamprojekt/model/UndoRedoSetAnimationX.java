package teamprojekt.model;

import javax.swing.undo.UndoableEdit;

public abstract class UndoRedoSetAnimationX implements UndoableEdit
{
    @Override
    public boolean addEdit(UndoableEdit edit)
    {
        return false;
    }

    @Override
    public boolean canRedo()
    {
        return true;
    }

    @Override
    public boolean canUndo()
    {
        return true;
    }

    @Override
    public void die()
    {
    }

    @Override
    public String getRedoPresentationName()
    {
        return null;
    }

    @Override
    public String getUndoPresentationName()
    {
        return null;
    }

    @Override
    public boolean isSignificant()
    {
        return true;
    }

    @Override
    public boolean replaceEdit(UndoableEdit arg0)
    {
        return false;
    }

    @Override
    public String getPresentationName()
    {
        return null;
    }
}