package teamprojekt.model;

import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

public class UndoRedoSetAnimation extends UndoRedoSetAnimationX
{

    private Sondieren sond;

    public UndoRedoSetAnimation(Sondieren sond)
    {
        this.sond = sond;
    }

    @Override
    public void undo() throws CannotUndoException
    {
        sond.prevPosition();
    }

    @Override
    public void redo() throws CannotRedoException
    {
        sond.redoPosition();
    }
}