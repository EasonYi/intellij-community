package org.jetbrains.jps.model.module;

import org.jetbrains.jps.model.JpsElementProperties;
import org.jetbrains.jps.model.JpsElementType;
import org.jetbrains.jps.model.JpsElementTypeWithDefaultProperties;

/**
 * @author nik
 */
//todo[nik] I'm not sure that we really need separate interface for facets in the project model.
//Perhaps facets should be replaced by extensions for module elements
public abstract class JpsFacetType<P extends JpsElementProperties> extends JpsElementType<P> implements JpsElementTypeWithDefaultProperties<P> {
}
