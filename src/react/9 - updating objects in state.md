Objects that technically mutable, as we can change what value it holds but React wont treat this as a state change and won't re-render, so the only way we can go forward is to replace the object as a whole to force a re-render.

